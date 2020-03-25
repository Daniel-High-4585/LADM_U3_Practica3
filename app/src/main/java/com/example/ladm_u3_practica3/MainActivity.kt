package com.example.ladm_u3_practica3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var player1 = Player(1)
    var player2 = Player(2)
    var player3= Player(3)
    var player4= Player(4)



    var yaTiro = true

    var hilotl  :Hilo?=null

    var turno = 1
    var ronda = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hilotl = Hilo(this)

        btnIniciar.setOnClickListener {
            try {
                hilotl!!.start()
                btnTirar.setEnabled(true)
                btnIniciar.setEnabled(false)
                rondatl()
            }catch (e:Exception){

            }
        }

        btnTirar.setOnClickListener {
            rondatl()
            if(turno==1){
                txtDado1.setText(player1.dado().toString())
                txtDado2.setText(player1.dado().toString())
                puntosP1.setText(player1.regresarPuntos().toString())
                turno++

                return@setOnClickListener
            }

            if(turno==2){
                txtDado1.setText(player2.dado().toString())
                txtDado2.setText(player2.dado().toString())
                puntosP2.setText(player2.regresarPuntos().toString())
                turno++

                return@setOnClickListener
            }

            if(turno==3){
                txtDado1.setText(player3.dado().toString())
                txtDado2.setText(player3.dado().toString())
                puntosP3.setText(player3.regresarPuntos().toString())
                turno++
                return@setOnClickListener
            }

            if(turno==4){
                txtDado1.setText(player4.dado().toString())
                txtDado2.setText(player4.dado().toString())
                puntosP4.setText(player4.regresarPuntos().toString())
                turno++
                ronda++
                condiciones()
                rondatl()
                return@setOnClickListener
            }


        }

    }
    fun rondatl(){
        txtRonda.setText("Ronda: "+ronda.toString())
    }

    fun condiciones(){
        if(turno==5 && ronda==5){
            btnTirar.setEnabled(false)
            elGanador()
        }

        if(turno==5){
            turno=1
        }
    }

    fun laMagia(){
        if(turno==1){
            textView.setText("Turno de: Player 1")
        }
        if(turno==2){
            textView.setText("Turno de: Player 2")
        }
        if(turno==3){
            textView.setText("Turno de: Player 3")
        }
        if(turno==4){
            textView.setText("Turno de: Player 4")
        }
    }

    fun elGanador(){
        hilotl!!.juego=false
        var p1 = player1.regresarPuntos()
        var p2 = player2.regresarPuntos()
        var p3 = player3.regresarPuntos()
        var p4 = player4.regresarPuntos()

        if(p1>p2){//p1 es mas grande que p2
            if(p1>p3){//p1 es mayo a p3
                if(p1>p4){//p1 mayor a p4
                    txtGanador.setText("El ganador es el Player 1")
                }else{//p4 es mayor a p1
                    txtGanador.setText("El ganador es el Player 4")
                }
            }else{//p3 es mayor a p1
                if(p3>p4){//p3 es mayo a p4
                    txtGanador.setText("El ganador es el Player 3")
                }else{//p4 es mayor a p3
                    txtGanador.setText("El ganador es el Player 4")
                }
            }
        }else{//p2 es mas grande que p1
            if(p2>p3){//p2 es mayor que p3
                if(p2>p4){//p2 es mayor a p4
                    txtGanador.setText("El ganador es el Player 2")
                }else{//p4 es mayor a p2
                    txtGanador.setText("El ganador es el Player 4")
                }
            }else{//p3 es mayo que p2
                if(p3>p4){//p3 es mayor a p4
                    txtGanador.setText("El ganador es el Player 3")
                }else{//p4 es mayor a p3
                    txtGanador.setText("El ganador es el Player 4")
                }
            }
        }


    }
}
