package org.somanath

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class StructuredConcurrency {
}

fun main() {
    val flowPractice = FlowPractice()
    runBlocking {
        launch {
            flowPractice.getNumber(10).map {
                if(it == 4) throw Exception("Error")
                it * it
            }.catch {
                println(" l1 Error: $it")
            }.collect {
                println("l1 $it")
            }

            flowPractice.getNumber(10).map {
                if(it == 6) throw Exception("Error")
                it * it
            }.catch { println("l2 Error: $it") }.collect {
                println("l2 $it")
            }
        }


    }
}