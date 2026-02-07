package org.somanath

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class AsyncPractice {
}

fun main() {
    val flowPractice = FlowPractice()

    runBlocking {
//        launch {
            async {
                flowPractice.getNumber(10).map {
                    if(it == 5) throw Exception(" 1 FlowPractice")
                    delay(100)
                    it * 2

                }.catch {
                    println("AS1 $it")
                }.collect {
                    println("AS1 $it")
                }
            }

            async {
                flowPractice.getNumber(10).map {
                    if(it == 5) throw Exception("2 FlowPractice")
                    delay(50)
                    it * 2

                }.catch { println("AS2 $it")
                }.collect {
                    println("AS2 $it")
                }
            }
//        }

    }
}