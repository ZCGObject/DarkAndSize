package com.ikang.mydark

import android.annotation.SuppressLint
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TimeUtils
import android.view.View
import android.widget.TextView
import java.util.concurrent.TimeUnit


class OomTestActivity : AppCompatActivity(), View.OnClickListener, LocationListener {

    open var count = 0
    lateinit var tv: TextView


    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oom_test)




//        for (i in 0 .. 100){
//            var t = Thread(MyRunnable(count++))
//            t.start()
//        }


//        var locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
//
//        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, TimeUnit.MINUTES.toMillis(5), 100F, this)

        tv = findViewById(R.id.tv)

        tv.setOnClickListener(this)





    }
     class MyRunnable(count: Int) : Runnable{
         var mCount = count
        override fun run() {
            Log.e("MyRunnable-->>>", "MyRunnable  开始运行 $mCount")
           Thread.sleep(2*60*1000)
        }

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun onLocationChanged(p0: Location?) {
        TODO("Not yet implemented")
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun onProviderEnabled(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onProviderDisabled(p0: String?) {
        TODO("Not yet implemented")
    }


}

