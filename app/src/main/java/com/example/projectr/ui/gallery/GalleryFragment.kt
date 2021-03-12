package com.example.projectr.ui.gallery

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.projectr.MyService
import com.example.projectr.R
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment() {

    private lateinit var mService: MyService
    private var mBound: Boolean = false

    private val connection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            val binder = service as MyService.LocalBinder
            mService = binder.getService()
            mBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("View")
        activity?.startService(Intent(activity, MyService::class.java))
        activity?.bindService(Intent(activity, MyService::class.java), connection, AppCompatActivity.BIND_AUTO_CREATE)
        controlSound()

    }

    private fun controlSound() {

        playFinal.setOnClickListener {
            activity?.bindService(Intent(activity, MyService::class.java), connection, AppCompatActivity.BIND_AUTO_CREATE)
            mService.playMusic()

        }

        pauseFinal.setOnClickListener {
            try{
                mService.pauseMusic()
            }
            catch(e: Exception){
                Toast.makeText(activity, "Error pause", Toast.LENGTH_LONG).show()
            }
        }

        stopFinal.setOnClickListener {
            try {
                mService.stopMusic()
                activity?.unbindService(connection)
            }
            catch (e: Exception) {
                Toast.makeText(activity, "Error stop", Toast.LENGTH_LONG).show()
            }

        }


    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.unbindService(connection)
    }
}