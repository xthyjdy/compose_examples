package vch.compose_ex.ex2

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import vch.compose_ex.Helper.l

@HiltAndroidApp
class Ex2DIApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        l("Ex2DIApplication");
    }

    companion object {
        const val TAG = "Ex2DIApplication"
    }
}