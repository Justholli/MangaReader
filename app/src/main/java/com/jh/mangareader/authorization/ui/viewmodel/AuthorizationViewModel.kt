package com.jh.mangareader.authorization.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor() : ViewModel() {
    val text = "Test"
}