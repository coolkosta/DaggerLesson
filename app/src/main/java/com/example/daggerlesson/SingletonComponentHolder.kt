package com.example.daggerlesson

object SingletonComponentHolder {

    private var INSTANCE: SingletonComponent? = null

    //Если создадим отдельный компонент и реализуем его в активити, то для той активити которая имеет первый экземпляр, иерархия будет разная
    //fun createNew()  = DaggerSingletonComponent.create()


    fun getSingletonComponent(): SingletonComponent {
        return INSTANCE ?: DaggerSingletonComponent.create().also {
            INSTANCE = it
        }
    }
}