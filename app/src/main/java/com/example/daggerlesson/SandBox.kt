package com.example.daggerlesson

import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Qualifier

interface IBar
class Bar @Inject constructor() : IBar
class AnotherBar @Inject constructor() : IBar

class Foo @Inject constructor(
    @ClassicBar private val bar: IBar,
    private val name: String,
    @Named("surname") private val surname: String
) {

    fun bar() {
        println("Hello World! $bar")
    }
}

@Module
interface BarModule {

    companion object {

        @Provides
        fun provideName() = "Kostya"

        @Provides
        @Named("surname")
        fun providesurname() = "Borzakov"
    }

    @Binds
    @ClassicBar
    fun bindBar(bar: Bar): IBar
}

@Qualifier
annotation class ClassicBar

@Component(modules = [BarModule::class])
interface FooComponent {

    fun inject(mainActivity: MainActivity)
}
