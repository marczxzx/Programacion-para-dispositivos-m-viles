/*
  Descripción: EditorActivity - escribe nota y la manda a OpcionesActivity
  Autor: Tu Nombre
  Fecha creación: 2025-09-24
*/
package com.example.editor_de_nota_rapida

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts


class EditorActivity : ComponentActivity() {

    private lateinit var etNota: EditText

    private val opcionesLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // OpcionesActivity mostró el Toast "Compartido por correo" antes de terminar
            } else if (result.resultCode == Activity.RESULT_CANCELED) {
                // Volvió para editar -> recuperar texto enviado
                val nota = result.data?.getStringExtra("nota")
                nota?.let { etNota.setText(it) }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        etNota = findViewById(R.id.etNota)

        savedInstanceState?.let {
            etNota.setText(it.getString("nota"))
        }

        findViewById<Button>(R.id.btnCompartir).setOnClickListener {
            val texto = etNota.text.toString()
            val intent = Intent(this, OpcionesActivity::class.java).apply {
                putExtra("nota", texto)
            }
            opcionesLauncher.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nota", etNota.text.toString())
    }
}
