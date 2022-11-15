package com.example.daggerlesson

import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Reusable
import javax.inject.Scope
import javax.inject.Singleton

@Singleton
@Component(modules = [CounterModule::class])
interface SingletonComponent {

    fun provideCounter(): ICounter
}

@Module
interface CounterModule {

    @Binds
    @Reusable
    fun bindCounter(counter: Counter): ICounter
}

/*@Scope
annotation class SingletonScope*/

@Scope
annotation class ActivityScope