package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ActivityDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val boundle = intent.extras

        val name=boundle!!.getString("name")
        val desc=boundle!!.getString("desc")
        val img=boundle!!.getInt("img")

        var imger:ImageView =findViewById(R.id.imageView2)
        var nameer:TextView  =findViewById(R.id.textView)
        var descer:TextView  =findViewById(R.id.textView2)

        imger.setImageResource(img)
        nameer.text=name
        descer.text=desc
    }
}