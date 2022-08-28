package com.cci.spaceoperators.mainMenu

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.cci.spaceoperators.R
import com.cci.spaceoperators.databinding.DialogUsernameBinding

class UsernameDialogFragment: DialogFragment() {
  private var _binding: DialogUsernameBinding? = null
  private lateinit var binding: DialogUsernameBinding
  private val usernameViewModel: UsernameViewModel by activityViewModels()


  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    _binding = DialogUsernameBinding.inflate(
      layoutInflater,
      null,
      false
    )
    binding = _binding!!

    val builder = AlertDialog.Builder(requireActivity())

    val dialog =
      builder
        .setMessage(resources.getString(R.string.menu_change_username))
        .setView(binding.root)
        .setPositiveButton(resources.getString(R.string.menu_save)) { dialog, id ->
          val prefs = requireActivity().getPreferences(Context.MODE_PRIVATE)

          prefs.edit()
            .putString("username", binding.usernameInput.text.toString())
            .apply()

          usernameViewModel.username.value =
            binding.usernameInput.text.toString()
        }
        .create()

    return dialog
  }
}
