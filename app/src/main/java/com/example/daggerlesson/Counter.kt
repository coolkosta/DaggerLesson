package com.example.daggerlesson

import javax.inject.Inject
import javax.inject.Singleton

interface ICounter {

    fun increment()
    fun getCountValue(): Int
}


class Counter @Inject constructor() : ICounter {

    private var count = 0

    override fun increment() {
        count++
    }

    override fun getCountValue(): Int = count
}
