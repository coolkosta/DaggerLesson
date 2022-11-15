package com.example.daggerlesson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var counter: ICounter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SingletonComponentHolder.getSingletonComponent()
            .mainActivityComponent()
            .create()
            .inject(this)

        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.increment).setOnClickListener {
            counter.increment()
            findViewById<TextView>(R.id.textViewMainActivity).text =
                counter.getCountValue().toString()
        }

        findViewById<View>(R.id.openBBtn).setOnClickListener {
            startActivity(Intent(this, ActivityB::class.java)
                .putExtra("name", "Konstantin")
                .putExtra("surname", "Borzakov"))
        }
    }
}