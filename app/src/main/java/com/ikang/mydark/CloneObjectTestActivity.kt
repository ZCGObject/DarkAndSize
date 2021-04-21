package com.ikang.mydark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class CloneObjectTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clone_object_test)




        var s1 = Student()
        s1.age = 100

        var s2 = s1.clone()

        var s3 = s1

        Log.e("student----->>>>", "s1.age::${s1.age}------s2.age::${s2.age}------s3.age::${s3.age}")

        s2.age = 666

        Log.e("student----->>>>", "s1.age::${s1.age}------s2.age::${s2.age}------s3.age::${s3.age}")

        s3.age = 888

        Log.e("student----->>>>", "s1.age::${s1.age}------s2.age::${s2.age}------s3.age::${s3.age}")

    }
}