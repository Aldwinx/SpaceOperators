package com.cci.spaceoperators.games.create

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cci.spaceoperators.databinding.FragmentCreateGameBinding
import com.cci.spaceoperators.sockets.SocketViewModel

class CreateGameFragment: Fragment() {
    private val socketViewModel: SocketViewModel by viewModels()

    private var _binding: FragmentCreateGameBinding? = null
    private lateinit var binding: FragmentCreateGameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateGameBinding.inflate(inflater, container, false)
        binding = _binding!!

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.createGameReturnButton.setOnClickListener {
            findNavController().navigate(CreateGameFragmentDirections.actionCreateGameFragmentToMainMenuFragment())
        }

        socketViewModel.ipAddress.observe(viewLifecycleOwner) { ip ->
            if (ip !== null) {
                Toast.makeText(requireContext().applicationContext, ip, Toast.LENGTH_SHORT).show()
            }
        }

    }
}
