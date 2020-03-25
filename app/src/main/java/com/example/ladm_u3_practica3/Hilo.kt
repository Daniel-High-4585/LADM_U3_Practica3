package com.example.ladm_u3_practica3

class Hilo (p:MainActivity):Thread(){


    var puntero = p //apuntador al activity
    var juego=true


    override fun run(){
        super.run()

        while(juego){
                sleep(10)
                puntero!!.laMagia()
        }
    }
    //Realmente no supe como usar los semaforos aqui profe
    //vi videos, intenta hacer un programa, pero no entendia el codigo pues explicaban mal
    // o quisas simplemente estoy bienw wey

}