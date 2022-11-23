package com.bigbackboom.tryandroidstuff.core.dispatcher

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatcherType: DispatcherType)

enum class DispatcherType {
    Main,
    IO
}

