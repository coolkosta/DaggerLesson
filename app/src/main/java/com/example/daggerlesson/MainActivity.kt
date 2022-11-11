package com.example.daggerlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var foo: Foo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerFooComponent.create().inject(this)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.button).setOnClickListener {
        foo.bar()
        }
    }
}