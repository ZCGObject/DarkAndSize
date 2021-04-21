package com.ikang.mydark.fanshe

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ikang.mydark.R

class FanSheActivity : AppCompatActivity() {


    val TAG = "FanSheActivity-->>>"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fan_she)


//        FanSheUtil.fanshe()


        val t1 = Any()
        val t2 = Any()


        object : Thread() {
            override fun run() {
                synchronized(t1) {
                    Log.e(TAG, "Thread1 get t1")
                    try {
//                        Log.e(TAG, "Thread1 doing 000")
                        sleep(1000)
//                        Log.e(TAG, "Thread1 doing 111")
                    } catch (e: Exception) {
                    }
                    Log.e(TAG, "Thread1 doing 222")
                    synchronized(t2) { Log.e(TAG, "Thread1 get t2") }
                }
            }
        }.start()

        object : Thread() {
            override fun run() {
                synchronized(t2) {
                    Log.e(TAG, "Thread2 get t2")
                    try {
//                        Log.e(TAG, "Thread2 doing 000")
                        sleep(1000)
//                        Log.e(TAG, "Thread2 doing  111")
                    } catch (e: Exception) {
                    }
                    Log.e(TAG, "Thread2 doing  222")
                    synchronized(t1) { Log.e(TAG, "Thread2 get t1") }
                }
            }
        }.start()




    }
}