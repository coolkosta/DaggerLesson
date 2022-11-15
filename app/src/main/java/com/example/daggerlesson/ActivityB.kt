package com.example.daggerlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import javax.inject.Inject

class ActivityB : AppCompatActivity() {

    @Inject
    lateinit var counter: ICounter

    @Inject
    lateinit var developer: Developer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra("name") ?: "Name"
        val surname = intent.getStringExtra("surname") ?: "Not get"

        SingletonComponentHolder.getSingletonComponent()
            .activityBComponent()
            .create(name, surname)
            .inject(this)

        setContentView(R.layout.activity_b)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = counter.getCountValue().toString()

        findViewById<View>(R.id.showNameBtn).setOnClickListener {
            textView.text = developer.getName()
        }
    }
}