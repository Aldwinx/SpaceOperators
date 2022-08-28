package com.cci.spaceoperators.mainMenu

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.cci.spaceoperators.R
import com.cci.spaceoperators.databinding.DialogJoinGameBinding
import com.cci.spaceoperators.sockets.SocketViewModel

class JoinGameDialogFragment: DialogFragment() {
  private var _binding: DialogJoinGameBinding? = null
  private lateinit var binding: DialogJoinGameBinding

  private val socketViewModel: SocketViewModel by viewModels()

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    _binding = DialogJoinGameBinding.inflate(
      layoutInflater,
      null,
      false
    )
    binding = _binding!!

    val builder = AlertDialog.Builder(requireActivity())

    val dialog =
      builder
        .setView(binding.root)
        .setPositiveButton(resources.getString(R.string.join_game_connect)) { dialog, id ->

          socketViewModel.sendUDPData("CONNECTED", binding.joinGameHostIpInput.text.toString())
          Toast.makeText(requireActivity().application, binding.joinGameHostIpInput.text.toString(), Toast.LENGTH_SHORT).show()
        }
        .create()

    return dialog
  }
}
