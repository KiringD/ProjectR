package com.example.projectr

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder

class MyService : Service() {
    private var mp: MediaPlayer? = null
    private val binder = LocalBinder()

    inner class LocalBinder : Binder() {
        // Return this instance of LocalService so clients can call public methods
        fun getService(): MyService = this@MyService
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        println("Service started")
        return super.onStartCommand(intent, flags, startId)
    }
    fun playMusic(){
        if (mp == null) {

            mp = MediaPlayer.create(this, R.raw.nt)
        }
        mp?.start()
    }

    fun pauseMusic(){
        mp?.pause()
    }

    fun stopMusic(){
        if (mp != null) {
            mp?.stop()
            mp?.reset()
            mp?.release()
            mp = null
        }
    }
}