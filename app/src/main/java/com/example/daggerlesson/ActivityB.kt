package com.example.daggerlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import javax.inject.Inject

class ActivityB : AppCompatActivity() {

    @Inject
    lateinit var counter: ICounter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerActivityBComponent
            .builder()
            .singletonComponent(SingletonComponentHolder.getSingletonComponent())
            .build()
            .inject(this)
        setContentView(R.layout.activity_b)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = counter.getCountValue().toString()
    }
}