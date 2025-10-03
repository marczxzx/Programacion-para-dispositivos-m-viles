/*
Descripción: Selección de tipo de comida; navega a SeleccionExtras.
Autor: Davis Arapa
Fecha creación: 01-01-2025
Fecha última modificación: 01-01-2025
*/
package com.example.practica5_fragmentsnavegacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class SeleccionComidaFragment : Fragment(R.layout.activity_seleccion_comida_fragment) {
    private var comidaSeleccionada: String? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val radioGroup = view.findViewById<android.widget.RadioGroup>(R.id.radioGroupComida)
        val btnSiguiente = view.findViewById<View>(R.id.btnSiguienteComida)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            comidaSeleccionada = when (checkedId) {
                R.id.opcPizza -> "Pizza"
                R.id.opcHamburguesa -> "Hamburguesa"
                R.id.opcFrejoles -> "Frejoles"
                else -> null
            }
            btnSiguiente.isEnabled = comidaSeleccionada != null
        }

        btnSiguiente.setOnClickListener {
            if (comidaSeleccionada != null) {
                // Crear el próximo Fragment y pasarle datos
                val fragment = SeleccionExtrasFragment()
                val bundle = Bundle()
                bundle.putString("comida", comidaSeleccionada)
                fragment.arguments = bundle  // pasar los argumentos

                // Navegar
                activity?.supportFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.fragment_container, fragment)
                    addToBackStack(null)
                    commit()
                }
            } else {
                Toast.makeText(context, "Selecciona una comida", Toast.LENGTH_SHORT).show()
            }
        }

        // Escuchar resultado de edición
        setFragmentResultListener("pedido_editar") { _, bundle ->
            val comida = bundle.getString("comida")
            when (comida) {
                "Pizza" -> radioGroup.check(R.id.opcPizza)
                "Hamburguesa" -> radioGroup.check(R.id.opcHamburguesa)
                "Frejoles" -> radioGroup.check(R.id.opcEnsalada)
            }
            this.comidaSeleccionada = comida
        }
    }
}