package com.example.daggerlesson

import javax.inject.Inject
import javax.inject.Named

class Developer @Inject constructor(
   @Named("name") private val name: String,
    private val surname: String
) {
    fun getName(): String {
        return "$name $surname"
    }
}