package com.cci.spaceoperators

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.cci.spaceoperators.databinding.ActivityMainBinding
import com.cci.spaceoperators.players.models.Player
import com.cci.spaceoperators.sockets.SocketViewModel


class MainActivity : AppCompatActivity() {
    private val socketViewModel: SocketViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Player(1, "a", "8888", true)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}
