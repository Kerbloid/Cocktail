package com.example.cocktailme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        get.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                    val respose = RetrofitClient.service.getRandom().execute()
                    if (respose.isSuccessful) {
                        Log.d(TAG, "successful")
                        Log.d(TAG, respose.body().toString())
                    } else {
                        Log.d(TAG, "not successful")
                    }
            }
        }
    }

    companion object {
        const val TAG = "b_MainActivity"
    }
}