package com.example.mydemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mydemo.model.CoinModel

class CoinViewModel(private val repo: CoinRepo) : ViewModel() {
    private var _coinResponse: MutableLiveData<CoinModel> = MutableLiveData()
    var coinResponse: MutableLiveData<CoinModel> = _coinResponse
    fun getCoinResponse() {
        repo.getCoinResponse(_coinResponse)
    }


    override fun onCleared() {
        super.onCleared()
        repo.dispose()
    }

    class CoinViewModelFactory(private var repository: CoinRepo) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CoinViewModel(repository) as T
        }

    }
}