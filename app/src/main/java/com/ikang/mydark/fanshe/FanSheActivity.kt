package com.ikang.mydark.fanshe

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ikang.mydark.R
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap

class FanSheActivity : AppCompatActivity() {


    val TAG = "FanSheActivity-->>>"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fan_she)


//        FanSheUtil.fanshe()


        var hashMap = HashMap<String, String>()
        var linkedHashMap = LinkedHashMap<String, String>()
        var treeMap = TreeMap<String, String>()

        var hashSet = HashSet<String>()
        Log.e(TAG, "-----------------------hashSet---------------------")
        hashSet.add("5")
        hashSet.add("1")
        hashSet.add("8")
        hashSet.add("2")
        hashSet.add("d")
        hashSet.add("a")
        hashSet.add("c")
        hashSet.forEach(){
            Log.e(TAG, "$it")
        }

        Log.e(TAG, "-----------------------hashMap---------------------")
        hashMap["5"] = "555"
        hashMap["1"] = "111"
        hashMap["8"] = "888"
        hashMap["2"] = "222"
        hashMap["d"] = "ddd"
        hashMap["a"] = "aaa"
        hashMap["c"] = "ccc"

        hashMap.forEach(){
            Log.e(TAG, "${it.key}____${it.value}")
        }
        Log.e(TAG, "-----------------------linkedHashMap---------------------")
        linkedHashMap["5"] = "555"
        linkedHashMap["1"] = "111"
        linkedHashMap["8"] = "888"
        linkedHashMap["2"] = "222"
        linkedHashMap["d"] = "ddd"
        linkedHashMap["a"] = "aaa"
        linkedHashMap["c"] = "ccc"

        linkedHashMap.forEach(){
            Log.e(TAG, "${it.key}____${it.value}")
        }

        Log.e(TAG, "---------------------treeMap-----------------------")
        treeMap["5"] = "555"
        treeMap["1"] = "111"
        treeMap["8"] = "888"
        treeMap["2"] = "222"
        treeMap["d"] = "ddd"
        treeMap["a"] = "aaa"
        treeMap["c"] = "ccc"

        treeMap.forEach(){
            Log.e(TAG, "${it.key}____${it.value}")
        }



    }
}