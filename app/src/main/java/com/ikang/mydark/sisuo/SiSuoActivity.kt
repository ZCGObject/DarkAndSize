package com.ikang.mydark.sisuo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ikang.mydark.R

class SiSuoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_si_suo)

        DieLock.siSuo()
    }
}