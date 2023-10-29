package com.example.IMCycalculadoras.ResultIMCActivity

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.IMCycalculadoras.R
import java.text.DecimalFormat

class ResultIMCActivity : AppCompatActivity() {

    /**formateador de datos*/
    val df = DecimalFormat("#.##")

    /**contiene el resultado, segun el cual mostraremos unas cosas u otras*/
    lateinit var resultado:String

    /**texto de respuesta*/
    lateinit var answerText : TextView

    /**texto del numero de respuesta*/
    lateinit var answerNumber : TextView

    /**imagen a mostrar*/
    lateinit var answerImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val extras = intent.extras
        //saca de extras el valor con el que vamos a operar y lo formatea, sustituyendo la , con .
        //porque el dFormat pone ,
        if (extras != null) {
            var value = extras.getString("key")
            resultado = df.format(value.toString().toDouble()).replace(',','.')
        }
        textFiller()
    }

    /**inicializa las variables que usamos y les da conntenido segun el resultado que hallamos
     * sacado de [resultado]*/
    private fun textFiller(){

        answerNumber = findViewById<TextView>(R.id.answer_number)
        answerNumber.text=resultado.toString()
        answerText = findViewById<TextView>(R.id.answer_phrase)
        answerImage = findViewById(R.id.weight_img)

        //segun lo que haya en resultado, le damos al texto una string u otra, y le damos a los
        //textos unos colores para hacerlos mas expresivos y cambiamos la imagen
        answerText.text = when(resultado.toDouble()){
            in 0f..18.5f->{
                answerNumber.setTextColor(resources.getColor(R.color.orange))
                answerText.setTextColor(resources.getColor(R.color.orange))
                answerImage.setImageResource(R.drawable.underweight)
                "Peso inferior al normal"
            }
            in 18.5f..24.9f->{

                answerNumber.setTextColor(resources.getColor(R.color.white))
                answerText.setTextColor(resources.getColor(R.color.white))
                answerImage.setImageResource(R.drawable.standard)
                "Peso normal"
            }
            in 25f..29.9f->{

                answerNumber.setTextColor(resources.getColor(R.color.slight_dark_blue))
                answerText.setTextColor(resources.getColor(R.color.slight_dark_blue))
                answerImage.setImageResource(R.drawable.overweight)
                "Peso superior al normal"
            }
            else->{

                answerNumber.setTextColor(resources.getColor(R.color.orange))
                answerText.setTextColor(resources.getColor(R.color.orange))
                answerImage.setImageResource(R.drawable.obese)
                "Obesidad"
            }
        }
    }
}