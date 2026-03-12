/* Curso: Análise e Desenvolvimento de Sistemas
    Aluno: Saulo Torres de Oliveira Assis
    Professor: André Gustavo
    Projeto: GALC - Inteligência em cada gota
*/

package com.example.galc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bt = findViewById<Button>(R.id.idCalcula)
        val gasolina = findViewById<EditText>(R.id.idValorGasolina)
        val alcool = findViewById<EditText>(R.id.idValorAlcool)
        val resultadoTexto = findViewById<TextView>(R.id.txtResultado)

        bt.setOnClickListener {
            val res = calcula(gasolina.text.toString(), alcool.text.toString())
            resultadoTexto.text = res
        }
    }

    fun calcula(valor_gasolina: String, valor_alcool: String): String {
        if (valor_gasolina == "" || valor_alcool == "") {
            Toast.makeText(applicationContext, "Informe os valores corretamente", Toast.LENGTH_SHORT).show()
            return ""
        }

        val valor = valor_alcool.toDouble() / valor_gasolina.toDouble()

        if (valor <= 0.7) {
            return "O Álcool é mais vantajoso!"
        } else {
            return "A Gasolina é mais vantajosa!"
        }
    }
}