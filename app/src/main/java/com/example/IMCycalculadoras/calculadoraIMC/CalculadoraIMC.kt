package com.example.IMCycalculadoras.calculadoraIMC

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.IMCycalculadoras.R
import com.example.IMCycalculadoras.ResultIMCActivity.ResultIMCActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import kotlin.math.pow

class CalculadoraIMC : AppCompatActivity() {

    var gender =0

    /**es el slider de altura*/
    lateinit var heighSlider : RangeSlider

    /**es el cuadro de la altura, en cms*/
    lateinit var heigh : TextView

    /**contiene la carta de hombre*/
    lateinit var manCardView: CardView

    /**contiene el layout de hombre*/
    lateinit var manLayout :LinearLayout

    /**contiene el layout de mujer*/
    lateinit var womanLayout :LinearLayout

    /**contiene la carta de mujer*/
    lateinit var womenCardView: CardView

    /**es el cuadro de la edad, el numero de años*/
    lateinit var age : TextView

    /**es el cuadro de peso, numero en kgs*/
    lateinit var weight : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_imc)
        init()

    }

    /**se ejecuta al iniciar, inicia to'do*/
    private fun init(){

        heigh = findViewById<TextView>(R.id.cms)

        heighSlider = findViewById<RangeSlider>(R.id.heigh_range)

        initRangeSlider()

        manCardView = findViewById(R.id.cardView_men)

        manLayout = findViewById<LinearLayout>(R.id.cardViewMen_layout)

        womenCardView = findViewById(R.id.cardView_women)

        womanLayout = findViewById<LinearLayout>(R.id.cardViewWomen_layout)

        age = findViewById(R.id.age)

        weight= findViewById(R.id.weight)

        initButtons()

    }

    /**inicia el rangeSlider*/
    private fun initRangeSlider(){

        heighSlider.addOnChangeListener { _, value, _ ->
            heigh.text = value.toInt().toString()
        }
        heighSlider.stepSize = 1f
    }

    /**inicia los botones, los dos de peso y los dos de edad y el de calcular*/
    @SuppressLint("SetTextI18n")
    private fun initButtons(){

        //los botones de genero cambian el genero y el color de los dos layout
        manCardView.setOnClickListener{
            gender = 1
            manLayout.setBackgroundColor(resources.getColor(R.color.blue))
            womanLayout.setBackgroundColor(resources.getColor(R.color.slight_dark_blue))
        }
        womenCardView.setOnClickListener{
            gender = 2
            womanLayout.setBackgroundColor(resources.getColor(R.color.blue))
            manLayout.setBackgroundColor(resources.getColor(R.color.slight_dark_blue))
        }

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

        //la formula es peso / altura(m)^2, hacemos la operacion y la pasamos a String
        findViewById<Button>(R.id.calculate_button).setOnClickListener {
            var value = (weight.text.toString().toDouble()/(heigh.text.toString().toDouble()/100).pow(2)).toString()

            //generamos un intent, le damos el dato de value con putExtra
            val i = Intent(this, ResultIMCActivity::class.java)
            i.putExtra("key", value)
            startActivity(i)
        }

    }
}