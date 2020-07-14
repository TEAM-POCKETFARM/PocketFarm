package com.pocketfarmer.pocketfarm

import androidx.lifecycle.MutableLiveData

class NetworkEvent : MutableLiveData<NetworkEvent.NetworkState>() {


    enum class NetworkState {
        LOADING, FAILURE, SUCCESS, ERROR
    }

    fun startLoading() {
        value = NetworkState.LOADING
    }

    fun handleResponse(response : Any?) {
        if (response is Throwable?) {
            value = when (response?.message) {
                NetworkState.FAILURE.toString() -> NetworkState.FAILURE
                else -> NetworkState.ERROR
            }
        } else {
            value = NetworkState.SUCCESS
        }
    }
}