package vch.compose_ex

import android.util.Log
import java.util.Objects

object Helper {
    const val prefix = "_____"
    const val LOG_TAG = "my_log"

    fun l(data: Any): Unit {
        Log.e("LOG_TAG", "$prefix$data")
    }
}