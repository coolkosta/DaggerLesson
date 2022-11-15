package com.example.daggerlesson


import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Named

@ActivityScope
@Subcomponent
interface ActivityBComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @Named("name") @BindsInstance name: String,
            @BindsInstance surname: String
        ): ActivityBComponent
    }

    fun inject(activityB: ActivityB)
}