package com.example.daggerlesson

import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Reusable
import javax.inject.Scope
import javax.inject.Singleton

@Singleton
@Component(modules = [CounterModule::class, SubcomponentsModule::class])
interface SingletonComponent {

    fun mainActivityComponent(): MainActivityComponent.Factory
    fun activityBComponent(): ActivityBComponent.Factory

    // Удаляем метод показа данного компонента на одну иерархию вниз.
    //fun provideCounter(): ICounter
}

@Module(subcomponents = [MainActivityComponent::class, ActivityBComponent::class])
interface SubcomponentsModule


@Module
interface CounterModule {

    @Binds
    @Singleton
    fun bindCounter(counter: Counter): ICounter
}

/*@Scope
annotation class SingletonScope*/

@Scope
annotation class ActivityScope