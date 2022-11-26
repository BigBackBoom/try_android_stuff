package com.bigbackboom.tryandroidstuff.data.datasource

sealed interface Response<T : Any>

class ResponseSuccess<T : Any>(val data: T) : Response<T>
class ResponseError<T : Any>(val code: Int, val message: String?) : Response<T>
