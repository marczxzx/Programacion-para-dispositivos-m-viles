package com.example.editor_de_nota_rapida

/*
  Descripción: OpcionesActivity - muestra nota, permite compartir o volver a editar
  Autor: Tu Nombre
  Fecha creación: 2025-09-24
*/


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity


class OpcionesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        val nota = intent.getStringExtra("nota") ?: ""
        findViewById<TextView>(R.id.tvNota).text = nota

        findViewById<Button>(R.id.btnCompartirCorreo).setOnClickListener {
            // Simular compartir por correo (solo mostrar toast)
            Toast.makeText(this, "Compartido por correo", Toast.LENGTH_SHORT).show()
            setResult(Activity.RESULT_OK)
            finish()
        }

        findViewById<Button>(R.id.btnEditarDeNuevo).setOnClickListener {
            val data = Intent().putExtra("nota", nota)
            setResult(Activity.RESULT_CANCELED, data)
            finish()
        }
    }
}
