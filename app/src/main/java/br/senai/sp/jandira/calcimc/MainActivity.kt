package br.senai.sp.jandira.calcimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    var weight = 0
    var height = 0.0
    var bmi = 0.0

     // Declarar as views da Activity
    lateinit  var buttonCalculate : Button
    lateinit var  editTextWeight :EditText
    lateinit var editTextHeight :EditText
    lateinit var textResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        // instanciamento das views

       buttonCalculate = findViewById(R.id.button_calculate)
       editTextWeight = findViewById(R.id.edit_text_weight)
        editTextHeight= findViewById(R.id.edit_text_height)
        textResult  = findViewById(R.id.text_Result)

        // Detectar o clique Do botão
        buttonCalculate.setOnClickListener{
            if (inputValidate()){
                bmiCalculate()
            }

        }
    }
    private fun inputValidate(): Boolean {
        if (editTextWeight.text.isEmpty()){
            editTextWeight.error = "Weight is required!"
            return false
        }
        if (editTextHeight.text.isEmpty()){
            editTextHeight.error = "Height is required"
            return false
        }
        return true
    }

    private fun bmiCalculate(){
        // Calcular o IMC

        // Conversão de editable para string e depois para int
        weight = editTextWeight.text.toString().toInt()
        height = editTextHeight.text.toString().toDouble()

        // Calculo do IMC
        bmi = weight/ height.pow(2.0)

        textResult.text = String.format("%.2f", bmi)
    }

}