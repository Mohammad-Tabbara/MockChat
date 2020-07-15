package com.mohammad.presentation._common.extensions

import androidx.lifecycle.MutableLiveData
import com.mohammad.presentation._common.models.Resource
import com.mohammad.presentation._common.models.ResourceState

fun <T> MutableLiveData<Resource<T>>.setSuccess(data: T) =
    postValue(
        Resource(
            ResourceState.SUCCESS,
            data
        )
    )

fun <T> MutableLiveData<Resource<T>>.setLoading() =
    postValue(
        Resource(
            ResourceState.LOADING,
            value?.data
        )
    )

fun <T> MutableLiveData<Resource<T>>.setError(exception: Exception? = null) =
    postValue(
        Resource(
            ResourceState.ERROR,
            value?.data,
            exception
        )
    )
