package com.cci.spaceoperators.mainMenu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class UsernameViewModel: ViewModel() {
    val username = MutableLiveData<String>(null);
}
