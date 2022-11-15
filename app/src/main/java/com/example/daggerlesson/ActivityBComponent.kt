package com.example.daggerlesson


import dagger.Component

@ActivityScope
@Component(dependencies = [SingletonComponent::class])
interface ActivityBComponent {

    fun inject(activityB: ActivityB)
}