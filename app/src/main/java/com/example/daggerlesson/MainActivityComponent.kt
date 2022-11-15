package com.example.daggerlesson

import dagger.Component
import dagger.Subcomponent
import javax.inject.Scope

@ActivityScope
@Subcomponent
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): MainActivityComponent
    }


    fun inject(mainActivity: MainActivity)
}
