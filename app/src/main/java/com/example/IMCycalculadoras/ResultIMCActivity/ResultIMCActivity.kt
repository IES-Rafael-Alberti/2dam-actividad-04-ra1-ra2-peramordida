package com.example.IMCycalculadoras.ResultIMCActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.IMCycalculadoras.R
import java.text.DecimalFormat

class ResultIMCActivity : AppCompatActivity() {

    val df = DecimalFormat("#.##")

    lateinit var resultado:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        resultado = df.format(resultado)
        textFiller()
    }

    private fun textFiller(){

        findViewById<TextView>(R.id.answer_number).text=resultado.toString()
        val answerText = findViewById<TextView>(R.id.answer_phrase)

        answerText.text = when(resultado.toDouble()){
            in 0f..18.5f->{
                "Peso inferior al normal"
            }
            in 18.5f..24.9f->{
                "Peso normal"
            }
            in 25f..29.9f->{
                "Peso superior al normal"
            }
            else->{
                "Obesidad"
            }
        }
    }
}