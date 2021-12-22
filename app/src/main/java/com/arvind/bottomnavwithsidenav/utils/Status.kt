package com.arvind.demoappbottom.utils

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}

class NetworkState(val status: Status, val msg: String) {
    companion object {
        val LOADED: NetworkState = NetworkState(Status.SUCCESS, "Success")
        val LOADING: NetworkState = NetworkState(Status.LOADING, "Running")
        val ERROR: NetworkState = NetworkState(Status.ERROR, "Failed")
    }
}