package com.example.acomesanavila.juego

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.animation.ObjectAnimator
import android.content.Intent
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        circulo.visibility=View.INVISIBLE
        circulo3.visibility=View.INVISIBLE
        circulo4.visibility=View.INVISIBLE
        button2.setOnClickListener(){
            animacion()
        }
        circulo.setOnClickListener(){
            contador++
            text.setText("puntuacion: $contador")
        }
        circulo3.setOnClickListener(){
            contador++
            text.setText("puntuacion: $contador")
        }
        circulo4.setOnClickListener(){
            contador++
            text.setText("puntuacion: $contador")
        }
        button3.setOnClickListener(){
            val intent = Intent(context, Main2Activity::class.java)
            startActivity(intent);
        }
    }

    var contador : Int=0
    private fun animarCirculo(patata: ImageView) = launch(UI) {
        // animacion: trasladamos en la direccion Y
        val objectAnimator = ObjectAnimator.ofFloat(
                patata,
                "translationY",
                3000f )
        objectAnimator.duration = 3000L
        objectAnimator.interpolator
        objectAnimator.repeatCount=(ObjectAnimator.INFINITE)
        objectAnimator.end()
        objectAnimator.start()
    }

    private fun animacion()=launch(UI){
        while(true) {
            var t = (Math.random() * 3).toInt()
            when (t) {
                0 -> {
                    circulo.visibility = View.VISIBLE
                    animarCirculo(circulo)

                }
                1 -> {
                    circulo3.visibility=View.VISIBLE
                    animarCirculo(circulo3)

                }
                2 -> {
                    circulo4.visibility=View.VISIBLE
                    animarCirculo(circulo4)


                }
            }
            delay(5000L)
        }
    }
}
