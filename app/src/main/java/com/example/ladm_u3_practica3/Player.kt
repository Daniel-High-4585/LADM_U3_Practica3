package com.example.ladm_u3_practica3

import kotlin.random.Random

class Player () {

    var puntos = 0

    var id = 0

    var d = 0

    constructor(x: Int) : this() {
        id = x
    }

    fun Random.nextInt(range: IntRange): Int {
        return range.start + nextInt(range.last - range.start)
    }

    fun dado(): Int{
        d=  Random.nextInt(1..6)
        puntos += d
        return d
    }

    fun regresaId():Int{
        return id
    }

    fun regresarPuntos():Int{
        return puntos
    }


}