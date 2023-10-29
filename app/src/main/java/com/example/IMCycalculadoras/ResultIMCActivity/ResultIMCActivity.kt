package com.example.IMCycalculadoras.ResultIMCActivity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.IMCycalculadoras.R
import java.text.DecimalFormat

class ResultIMCActivity : AppCompatActivity() {

    val df = DecimalFormat("#.##")

    lateinit var resultado:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val extras = intent.extras
        if (extras != null) {
            var value = extras.getString("key")
            resultado = df.format(value.toString().toDouble()).replace(',','.')
        }
        textFiller()
    }

    private fun textFiller(){

        val answerNumber = findViewById<TextView>(R.id.answer_number)
            answerNumber.text=resultado.toString()
        val answerText = findViewById<TextView>(R.id.answer_phrase)

        answerText.text = when(resultado.toDouble()){
            in 0f..18.5f->{
                answerNumber.setTextColor(resources.getColor(R.color.orange))
                answerText.setTextColor(resources.getColor(R.color.orange))
                "Peso inferior al normal"
            }
            in 18.5f..24.9f->{

                answerNumber.setTextColor(resources.getColor(R.color.white))
                answerText.setTextColor(resources.getColor(R.color.white))
                "Peso normal"
            }
            in 25f..29.9f->{

                answerNumber.setTextColor(resources.getColor(R.color.slight_dark_blue))
                answerText.setTextColor(resources.getColor(R.color.slight_dark_blue))
                "Peso superior al normal"
            }
            else->{

                answerNumber.setTextColor(resources.getColor(R.color.orange))
                answerText.setTextColor(resources.getColor(R.color.orange))
                "Obesidad"
            }
        }
    }
}