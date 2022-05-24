package com.groke.materialapp.viewmodel

sealed class AppState {
    object Loading : AppState()
    data class Error(val error: String) : AppState()
    object Success : AppState()
}