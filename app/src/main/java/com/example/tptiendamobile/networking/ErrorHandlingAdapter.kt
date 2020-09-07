package com.example.tptiendamobile.networking

import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.io.IOException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.concurrent.Executor


class ErrorHandlingAdapter {

    /** A callback which offers granular callbacks for various conditions.  */
    internal interface MyCallback<T> {
        /** Called for [200, 300) responses.  */
        fun success(response: Response<T?>?)

        /** Called for 401 responses.  */
        fun unauthenticated(response: Response<*>?)

        /** Called for [400, 500) responses, except 401.  */
        fun clientError(response: Response<*>?)

        /** Called for [500, 600) response.  */
        fun serverError(response: Response<*>?)

        /** Called for network errors while making the call.  */
        fun networkError(e: IOException?)

        /** Called for unexpected errors while making the call.  */
        fun unexpectedError(t: Throwable?)
    }

    internal interface MyCall<T> {
        fun cancel()
        fun enqueue(callback: MyCallback<T?>?)
        fun clone(): MyCall<T?>? // Left as an exercise for the reader...
        // TODO MyResponse<T> execute() throws MyHttpException;
    }

    class ErrorHandlingCallAdapterFactory : CallAdapter.Factory() {
        override fun get(returnType: Type?, annotations: Array<Annotation?>?, retrofit: Retrofit?): CallAdapter<*, *>? {
            if (getRawType(returnType) != MyCall::class.java) {
                return null
            }
            check(returnType is ParameterizedType) { "MyCall must have generic type (e.g., MyCall<ResponseBody>)" }
            val responseType: Type? = getParameterUpperBound(0, returnType as ParameterizedType?)
            val callbackExecutor: Executor? = retrofit?.callbackExecutor()
            return ErrorHandlingCallAdapter<Any?>(responseType, callbackExecutor)
        }

        private class ErrorHandlingCallAdapter<R> internal constructor(private val responseType: Type?, private val callbackExecutor: Executor?) : CallAdapter<R?, MyCall<R?>?> {
            override fun responseType(): Type? {
                return responseType
            }

            override fun adapt(call: Call<R?>?): MyCall<R?>? {
                return MyCallAdapter<R?>(call, callbackExecutor)
            }

        }
    }

    internal class MyCallAdapter<T>(private val call: Call<T?>?, private val callbackExecutor: Executor?) : MyCall<T?> {
        override fun cancel() {
            call?.cancel()
        }

        override fun enqueue(callback: MyCallback<T?>?) {
            call?.enqueue(object : Callback<T?> {
                override fun onResponse(call: Call<T?>?, response: Response<T?>?) {
                    // TODO if 'callbackExecutor' is not null, the 'callback' methods should be executed
                    // on that executor by submitting a Runnable. This is left as an exercise for the
                    // reader.
                    when (response?.code()) {
                        in 200..299 -> {
                            callback?.success(response)
                        }
                        401 -> {
                            callback?.unauthenticated(response)
                        }
                        in 400..499 -> {
                            callback?.clientError(response)
                        }
                        in 500..599 -> {
                            callback?.serverError(response)
                        }
                        else -> {
                            callback?.unexpectedError(RuntimeException("Unexpected response $response"))
                        }
                    }
                }

                override fun onFailure(call: Call<T?>?, t: Throwable?) {
                    if (t is IOException) {
                        callback?.networkError(t as IOException?)
                    } else {
                        callback?.unexpectedError(t)
                    }
                }
            })
        }

        override fun clone(): MyCall<T?>? {
            return MyCallAdapter<T?>(call?.clone(), callbackExecutor)
        }

    }

    internal interface HttpBinService {
        @get:GET("/ip")
        val ip: MyCall<Ip?>?
    }

    internal class Ip {
        var origin: String? = null
    }

    companion object {
        fun main() {
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://uaicastelar.ddns.net:6681/api/")
                    .addCallAdapterFactory(ErrorHandlingCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            val service = retrofit?.create(HttpBinService::class.java)
            val ip = service?.ip
            ip?.enqueue(
                    object : MyCallback<Ip?> {
                        override fun success(response: Response<Ip?>?) {
                            println("SUCCESS! " + response?.body()?.origin)
                        }

                        override fun unauthenticated(response: Response<*>?) {
                            println("UNAUTHENTICATED")
                        }

                        override fun clientError(response: Response<*>?) {
                            println("CLIENT ERROR " + response?.code().toString() + " " + response?.message())
                        }

                        override fun serverError(response: Response<*>?) {
                            println("SERVER ERROR " + response?.code().toString() + " " + response?.message())
                        }

                        override fun networkError(e: IOException?) {
                            System.err.println("NETWORK ERROR " + e?.message)
                        }

                        override fun unexpectedError(t: Throwable?) {
                            System.err.println("FATAL ERROR " + t?.message)
                        }
                    })
        }
    }
}