package org.somanath

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.runBlocking

class FlowPractice {

     fun getNumber(range:Int): Flow<Int> = flow {
        var i = 0
        repeat(range, { emit(i++)})
    }

     fun getSquares(range:Int): Flow<Int> = flow {
        var i = 0
        repeat(range, {
            emit(i*i)
            i++
        })
    }
}

fun main() {
    val flowPractice = FlowPractice()
    runBlocking {
        try {
            flowPractice.getNumber(5).map {
                if(it == 2) throw Exception()
                it * it
            }.catch {
                println("Error: $it")
            }.shareIn(this, SharingStarted.Eagerly, 0).collect {
                if(it == 9) throw Exception()
                println(it)
            }
        } catch (e: Exception) {
            println("Error: $e")
        }

    }


    println(flowPractice.getSquares(2))
}




