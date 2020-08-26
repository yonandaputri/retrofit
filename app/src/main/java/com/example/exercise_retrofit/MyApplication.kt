package com.example.exercise_retrofit

import android.app.Application

// MyApplication membungkus appContainer
// menghindari companion object makannya appContainer ditaruh di MyApplication
// kalau ada activity lain biar alamat memory nya sama makannya AppContainer hanya dipanggil 1 kali
class MyApplication : Application() {
    //val appContainer: AppContainer = AppContainer()
    val applicationComponent: ApplicationComponent = DaggerApplicationComponent.create()
}