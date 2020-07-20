package com.mohammad.presentation._common.extensions

import java.text.SimpleDateFormat
import java.util.*

val Long.timeFormat: String
    get() {
        val format = SimpleDateFormat("HH:mm:ss", Locale.US)
        return format.format(Date(this))
    }