package com.example.ladm_u3_practica3

import kotlin.random.Random

class HiloJugador (p:MainActivity):Thread(){



    fun Random.nextInt(range: IntRange): Int {
        return range.start + nextInt(range.last - range.start)
    }

    fun dado1(): Int{
        return  Random.nextInt(1..6)
    }
    fun dado2(): Int{
        return  Random.nextInt(1..6)
    }
}