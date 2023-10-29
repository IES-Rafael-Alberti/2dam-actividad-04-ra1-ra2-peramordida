package com.example.IMCycalculadoras.calculadoraIMC

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.IMCycalculadoras.R
import com.example.IMCycalculadoras.ResultIMCActivity.ResultIMCActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import kotlin.math.pow

class CalculadoraIMC : AppCompatActivity() {

    lateinit var genderButtons : Array<CardView>

    lateinit var heighSlider : RangeSlider

    lateinit var heigh : TextView

    lateinit var age : TextView

    lateinit var weight : TextView

    var genero = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_imc)
        init()

    }

    private fun init(){

        heigh = findViewById<TextView>(R.id.cms)

        heighSlider = findViewById<RangeSlider>(R.id.heigh_range)

        initRangeSlider()

        genderButtons = arrayOf(findViewById(R.id.cardView_men), findViewById(R.id.cardaView_women))

        age = findViewById(R.id.age)

        weight= findViewById(R.id.weight)

        initButtons()

    }

    private fun initRangeSlider(){

        heighSlider.addOnChangeListener { _, value, _ ->
            heigh.text = value.toInt().toString()
        }
        heighSlider.stepSize = 1f
    }

    @SuppressLint("SetTextI18n")
    private fun initButtons(){

        findViewById<FloatingActionButton>(R.id.weight_down).setOnClickListener {
            val peso = weight.text
            if(peso.toString().toInt() >1) weight.text = (peso.toString().toInt()-1).toString()
        }
        findViewById<FloatingActionButton>(R.id.weight_up).setOnClickListener {
            val peso = weight.text
            if(peso.toString().toInt() <500) weight.text = (peso.toString().toInt()+1).toString()
        }
        findViewById<FloatingActionButton>(R.id.age_down).setOnClickListener {
            val edad = age.text
            if(edad.toString().toInt()>1) age.text = (edad.toString().toInt()-1).toString()
        }

        findViewById<FloatingActionButton>(R.id.age_up).setOnClickListener {
            val edad = age.text
            if(edad.toString().toInt()<120) age.text = (edad.toString().toInt()+1).toString()
        }

        findViewById<Button>(R.id.calculate_button).setOnClickListener {
            var value = (weight.text.toString().toDouble()/(heigh.text.toString().toDouble()/100).pow(2)).toString()

            val i = Intent(this, ResultIMCActivity::class.java)
            i.putExtra("key", value)
            startActivity(i)
        }

    }
}