package com.example.IMCycalculadoras.calculadoraJosema

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.IMCycalculadoras.R

class CalculadoraJosema: AppCompatActivity()  {

    //Declaración de variables
    private lateinit var resultado: TextView
    private lateinit var boton_atras: Button
    private lateinit var boton_punto: Button
    private lateinit var boton_CE: Button
    private lateinit var boton_igual: Button
    private lateinit var boton_mas: Button
    private lateinit var boton_menos: Button
    private lateinit var boton_multiplicar: Button
    private lateinit var boton_dividir: Button
    private lateinit var boton1: Button
    private lateinit var boton2: Button
    private lateinit var boton3: Button
    private lateinit var boton4: Button
    private lateinit var boton5: Button
    private lateinit var boton6: Button
    private lateinit var boton7: Button
    private lateinit var boton8: Button
    private lateinit var boton9: Button
    private lateinit var boton0: Button

    var calculo = Calculo()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.xml_josema)

        //Inicializamos las variables al inicio de la App
        resultado = findViewById(R.id.resultado)
        boton_CE = findViewById(R.id.boton_ce)
        boton_igual = findViewById(R.id.boton_igual)
        boton_mas = findViewById(R.id.boton_mas)
        boton_menos = findViewById(R.id.boton_menos)
        boton_multiplicar = findViewById(R.id.boton_multiplicar)
        boton_dividir = findViewById(R.id.boton_dividir)
        boton_atras = findViewById(R.id.boton_atras)
        boton_punto = findViewById(R.id.boton_punto)
        boton1 = findViewById(R.id.boton_1)
        boton2 = findViewById(R.id.boton_2)
        boton3 = findViewById(R.id.boton_3)
        boton4 = findViewById(R.id.boton_4)
        boton5 = findViewById(R.id.boton_5)
        boton6 = findViewById(R.id.boton_6)
        boton7 = findViewById(R.id.boton_7)
        boton8 = findViewById(R.id.boton_8)
        boton9 = findViewById(R.id.boton_9)
        boton0 = findViewById(R.id.boton_0)

        boton_CE.setOnClickListener {
            calculo.operacion = ""
            calculo.resultado = 0.0
            resultado.text = "0"
        }

        boton_atras.setOnClickListener {
            calculo.operacion = calculo.operacion.dropLast(1)
            resultado.text = calculo.operacion
        }

        boton_punto.setOnClickListener {
            if (!comprobarPuntos(calculo.operacion)){
                calculo.operacion += "."
                resultado.text = calculo.operacion
            }
        }

        boton_igual.setOnClickListener {

            try {

                val numero1 = calculo.operacion.split("+","x","-","/")[0]

                val numero2 = calculo.operacion.split("+","x","-","/")[1]

                if (comprobarSignos(calculo.operacion) && numero1.isNotEmpty() && numero2.isNotEmpty()){
                    resultado.text = calculo.Calcular().toString()
                    calculo.operacion = ""

                }else Toast.makeText(this,"error, faltan datos",2.toInt()).show()
            }catch (e:Exception){
                Toast.makeText(this,"error, falta un numero",2.toInt()).show()
            }
        }

        boton1.setOnClickListener {
            calculo.operacion += 1
            resultado.text = calculo.operacion
        }

        boton2.setOnClickListener {
            calculo.operacion += 2
            resultado.text = calculo.operacion
        }

        boton3.setOnClickListener {
            calculo.operacion += 3
            resultado.text = calculo.operacion
        }

        boton4.setOnClickListener {
            calculo.operacion += 4
            resultado.text = calculo.operacion
        }

        boton5.setOnClickListener {
            calculo.operacion += 5
            resultado.text = calculo.operacion
        }

        boton6.setOnClickListener {
            calculo.operacion += 6
            resultado.text = calculo.operacion
        }

        boton7.setOnClickListener {
            calculo.operacion += 7
            resultado.text = calculo.operacion
        }

        boton8.setOnClickListener {
            calculo.operacion += 8
            resultado.text = calculo.operacion
        }

        boton9.setOnClickListener {
            calculo.operacion += 9
            resultado.text = calculo.operacion
        }

        boton0.setOnClickListener {
            calculo.operacion += 0
            resultado.text = calculo.operacion
        }

        boton_mas.setOnClickListener {
            if (!comprobarSignos(calculo.operacion)) {
                calculo.operacion += "+"
                resultado.text = calculo.operacion
            }
        }

        boton_menos.setOnClickListener {
            if (!comprobarSignos(calculo.operacion)) {
                calculo.operacion += "-"
                resultado.text = calculo.operacion
            }
        }

        boton_multiplicar.setOnClickListener {
            if (!comprobarSignos(calculo.operacion)) {
                calculo.operacion += "x"
                resultado.text = calculo.operacion
            }
        }

        boton_dividir.setOnClickListener {
            if (!comprobarSignos(calculo.operacion)) {
                calculo.operacion += "/"
                resultado.text = calculo.operacion
            }
        }

    }
}

fun comprobarSignos(cadena: String): Boolean{
    for (caracter in cadena){
        if (caracter.toString() in arrayOf("+", "-", "/", "x")){
            return true
        }
    }
    return cadena.isEmpty()
}

fun comprobarPuntos(cadena: String): Boolean{
    for (caracter in cadena){
        if (caracter.toString() in arrayOf(".")){
            return true
        }
    }
    return cadena.isEmpty()
}
