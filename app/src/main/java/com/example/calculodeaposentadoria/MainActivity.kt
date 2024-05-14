package com.example.calculodeaposentadoria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)
        val txt_idade = findViewById<EditText>(R.id.txt_idade)
        val btn_Calcular = findViewById<Button>(R.id.btn_Calcular)
        val txt_Resultado = findViewById<TextView>(R.id.txt_Resultado)

        spn_sexo.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("Masculino", "Feminino")
        )
        btn_Calcular.setOnClickListener {
            val sexo = spn_sexo.selectedItem as String
            val idadeText = txt_idade.text.toString()

            if (idadeText.isNotEmpty()) {
                val idade = idadeText.toInt()
                val resultado = if (sexo == "Masculino") {
                    65 - idade
                } else {
                    57 - idade
                }
                txt_Resultado.text = "Faltam $resultado anos para você se aposentar"
            } else {
                txt_Resultado.text = "Por favor, insira uma idade válida."
            }
        }

    }
}