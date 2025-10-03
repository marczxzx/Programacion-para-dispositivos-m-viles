/*
Autor: Davis Arapa
Fecha creación: 01-01-2025
Fecha última modificación: 01-01-2025
*/

package com.example.practica5_fragmentsnavegacion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Mostrar InicioFragment solo si aún no hay fragment
        if (savedInstanceState == null) {
            // Mostrar InicioFragment
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, InicioFragment(), "inicio")
                commit()
            }
        }
    }
}
