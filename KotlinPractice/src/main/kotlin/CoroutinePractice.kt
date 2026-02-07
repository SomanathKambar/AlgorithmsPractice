package org.somanath

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

class CoroutinePractice {

    suspend fun getNumber(range:Int): List<Int> {
        val result = mutableListOf<Int>()
        var i = 0
        repeat(range, { result.add(i++)})
        return result
    }


    suspend fun getSquares(range:Int): List<Int> {
        val result = mutableListOf<Int>()
        var i = 0
        repeat(range, { result.add(i*i)
            i++
        })
        return result
    }

}

fun main() {
    val coroutine = CoroutinePractice()
    runBlocking {

        val exceptionHandler = CoroutineExceptionHandler { ctx, ex ->
            println("CoroutineExceptionHandler got $ex")
        }
            supervisorScope() {

                val job1 =   launch(exceptionHandler) {
//                    try {
                      ensureActive()
                      delay(100)
                    println(coroutine.getNumber(10))
                    throw Exception()
//                      } catch (e: Exception) {
//                println("Exception: $e")
//
//            }
                }

                    delay(1000)
                    job1.cancel()

                launch {
                    delay(100)
                    println(coroutine.getSquares(10))
                }
            }
    }
}

