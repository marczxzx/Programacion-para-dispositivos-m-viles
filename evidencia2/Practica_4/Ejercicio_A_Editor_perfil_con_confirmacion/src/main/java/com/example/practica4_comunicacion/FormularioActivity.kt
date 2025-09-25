package com.example.practica4_comunicacion

/*
  Descripción: FormularioActivity - captura datos y lanza ResumenActivity
  Autor: Tu Nombre
  Fecha creación: 2025-09-24
*/

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts


class FormularioActivity : ComponentActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etCorreo: EditText

    private val resumenLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // La segunda activity confirmó
                Toast.makeText(this, "Perfil guardado correctamente", Toast.LENGTH_SHORT).show()
            } else {
                // Volvió para editar (no mostramos toast)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        etCiudad = findViewById(R.id.etCiudad)
        etCorreo = findViewById(R.id.etCorreo)

        // Restaurar si hubo rotación
        savedInstanceState?.let {
            etNombre.setText(it.getString("nombre"))
            etEdad.setText(it.getString("edad"))
            etCiudad.setText(it.getString("ciudad"))
            etCorreo.setText(it.getString("correo"))
        }

        findViewById<Button>(R.id.btnContinuar).setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val edad = etEdad.text.toString().toIntOrNull() ?: -1
            val ciudad = etCiudad.text.toString().trim()
            val correo = etCorreo.text.toString().trim()

            if (nombre.isEmpty() || edad <= 0 || ciudad.isEmpty() || correo.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos correctamente", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usuario = Usuario(nombre, edad, ciudad, correo)
            val intent = Intent(this, ResumenActivity::class.java).apply {
                putExtra("usuario", usuario)
            }
            resumenLauncher.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nombre", etNombre.text.toString())
        outState.putString("edad", etEdad.text.toString())
        outState.putString("ciudad", etCiudad.text.toString())
        outState.putString("correo", etCorreo.text.toString())
    }
}
