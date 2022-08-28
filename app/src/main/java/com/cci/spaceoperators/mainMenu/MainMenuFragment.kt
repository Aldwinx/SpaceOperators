package com.cci.spaceoperators.mainMenu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cci.spaceoperators.databinding.FragmentMainMenuBinding
import kotlin.system.exitProcess

class MainMenuFragment : Fragment() {
    private var _binding: FragmentMainMenuBinding? = null
    private lateinit var binding: FragmentMainMenuBinding

    private val usernameViewModel: UsernameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        binding = _binding!!

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usernameSetup()

        createGameSetup()

        joinGameSetup()

        historyGamesSetup()

        leaveAppSetup()

    }

    fun usernameSetup() {
        binding.mainMenuUsernameButton.setOnClickListener {
            openUsernameDialog()
        }

        val username =
            requireActivity().getPreferences(Context.MODE_PRIVATE)
                .getString("username", null)

        if (username !== null) {
            binding.mainMenuUsernameTextView.text = username
        }

        usernameViewModel.username.observe(viewLifecycleOwner) { user ->
            if (user != null) {
                binding.mainMenuUsernameTextView.text = user
            }
        }
    }

    private fun createGameSetup() {
        binding.createGameButton.setOnClickListener {
            findNavController().navigate(MainMenuFragmentDirections.actionMainMenuFragmentToCreateGameFragment())
        }
    }

    private fun joinGameSetup() {
        binding.joinGameButton.setOnClickListener {
            openJoinGameDialog()
        }
    }

    private fun historyGamesSetup() {
        binding.historyGamesButton.setOnClickListener {
            findNavController().navigate(MainMenuFragmentDirections.actionMainMenuFragmentToHistoryGamesFragment())
        }
    }

    private fun leaveAppSetup() {
        binding.leaveAppButton.setOnClickListener() {
            exitProcess(0)
        }
    }

    private fun openUsernameDialog() {
        UsernameDialogFragment()
            .show(
                parentFragmentManager,
                "username-dialog"
            )
    }

    private fun openJoinGameDialog() {
        JoinGameDialogFragment()
            .show(
                parentFragmentManager,
                "join-game-dialog"
            )
    }

}
