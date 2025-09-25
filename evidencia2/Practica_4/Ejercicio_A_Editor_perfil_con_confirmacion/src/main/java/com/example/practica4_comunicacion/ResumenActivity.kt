package com.example.practica4_comunicacion

/*
  Descripción: ResumenActivity - muestra datos recibidos y devuelve resultado
  Autor: Tu Nombre
  Fecha creación: 2025-09-24
*/

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class ResumenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        val usuario = intent.getSerializableExtra("usuario") as? Usuario

        findViewById<TextView>(R.id.tvNombre).text = "Nombre: ${usuario?.nombre ?: ""}"
        findViewById<TextView>(R.id.tvEdad).text = "Edad: ${usuario?.edad ?: ""}"
        findViewById<TextView>(R.id.tvCiudad).text = "Ciudad: ${usuario?.ciudad ?: ""}"
        findViewById<TextView>(R.id.tvCorreo).text = "Correo: ${usuario?.correo ?: ""}"

        findViewById<Button>(R.id.btnConfirmar).setOnClickListener {
            setResult(Activity.RESULT_OK) // confirma y regresa
            finish()
        }
        findViewById<Button>(R.id.btnVolverEditar).setOnClickListener {
            setResult(Activity.RESULT_CANCELED) // vuelve a editar
            finish()
        }
    }
}
