package misc

import kotlin.concurrent.thread
import kotlin.random.Random
import kotlin.random.nextLong

fun main() {
    (0..500).forEach { n ->
        val sleepTime = Random.nextLong(range = 0..1000L)
        thread (isDaemon = true){
            Thread.sleep(sleepTime)
            println("${Thread.currentThread().name} for $n after ${sleepTime}ms")
        }
    }
}
