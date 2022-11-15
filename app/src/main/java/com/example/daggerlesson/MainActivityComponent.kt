package com.example.daggerlesson

import dagger.Component
import javax.inject.Scope

@ActivityScope
@Component(dependencies = [SingletonComponent::class])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)
}
