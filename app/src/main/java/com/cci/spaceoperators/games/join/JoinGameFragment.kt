package com.cci.spaceoperators.games.join

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cci.spaceoperators.databinding.FragmentCreateGameBinding


class JoinGameFragment: Fragment() {
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
    }
}
