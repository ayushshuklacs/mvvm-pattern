package com.example.mydemo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mydemo.model.CoinModel
import com.example.mydemo.network.RetrofitClient
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class CoinRepo {
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getCoinResponse(response: MutableLiveData<CoinModel>) {
        try {

            val observer = RetrofitClient.apiInterface()?.getCoinInfo()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeWith(object : DisposableObserver<CoinModel>() {
                    override fun onNext(it: CoinModel) {
                        response.value = it


                    }

                    override fun onError(e: Throwable) {
                        Log.d("TAG", "error: ${Gson().toJson(e)}")

                    }

                    override fun onComplete() {

                    }

                })



            observer?.let { compositeDisposable.add(it) }
        } catch (e: Exception) {
            Log.d("TAG", "exception: ${e.localizedMessage}")
        }

    }
    fun dispose(){
        compositeDisposable.dispose()
    }
}