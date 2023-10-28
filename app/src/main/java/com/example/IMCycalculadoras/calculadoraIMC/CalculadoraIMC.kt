package com.example.IMCycalculadoras.calculadoraIMC

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.IMCycalculadoras.R
import com.google.android.material.slider.RangeSlider

class CalculadoraIMC : AppCompatActivity() {

    lateinit var botonesGenero : Array<CardView>

    lateinit var medidorAltura : RangeSlider

    lateinit var altura : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_imc)
        init()
    }

    private fun init(){

        altura = findViewById<TextView>(R.id.cms)

        medidorAltura = findViewById<RangeSlider>(R.id.heigh_range)

        initRangeSlider()

        botonesGenero = arrayOf(findViewById(R.id.cardView_men), findViewById(R.id.cardaView_women))

    }

    private fun initRangeSlider(){

        medidorAltura.addOnChangeListener { _, value, _ ->
            altura.text = value.toInt().toString()
        }
        medidorAltura.stepSize = 1f
    }
}