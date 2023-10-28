package com.example.IMCycalculadoras.calculadoraIMC

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.IMCycalculadoras.R
import com.google.android.material.slider.RangeSlider

class CalculadoraIMC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_imc)

        val texto = findViewById<TextView>(R.id.cms)
        val rangeSlider = findViewById<RangeSlider>(R.id.rangoAltura)
        rangeSlider.addOnChangeListener { _, value, _ ->
            texto.text = value.toInt().toString()
        }
        rangeSlider.stepSize = 1f
    }
}