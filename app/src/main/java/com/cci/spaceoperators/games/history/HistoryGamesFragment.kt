package com.cci.spaceoperators.games.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cci.spaceoperators.databinding.FragmentHistoryGamesBinding


class HistoryGamesFragment: Fragment() {
    private var _binding: FragmentHistoryGamesBinding? = null
    private lateinit var binding: FragmentHistoryGamesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoryGamesBinding.inflate(inflater, container, false)
        binding = _binding!!

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.historyGamesReturnButton.setOnClickListener{
            findNavController().navigate(HistoryGamesFragmentDirections.actionHistoryGamesFragmentToMainMenuFragment())
        }
    }
}
