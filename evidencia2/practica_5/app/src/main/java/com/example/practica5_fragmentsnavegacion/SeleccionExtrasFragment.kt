/*
Descripción: Selección de extras
Autor: Davis Arapa
Fecha creación: 01-01-2025
Fecha última modificación: 01-01-2025
*/
package com.example.practica5_fragmentsnavegacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SeleccionExtrasFragment : Fragment(R.layout.activity_seleccion_extras_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recibir la comida
        val comida = arguments?.getString("comida") ?: run {
            // Si no hay comida, vuelve atrás
            activity?.onBackPressed()
            return
        }

        val cbBebida = view.findViewById<android.widget.CheckBox>(R.id.opcBebida)
        val cbPapas = view.findViewById<android.widget.CheckBox>(R.id.opcPapas)
        val cbPostre = view.findViewById<android.widget.CheckBox>(R.id.opcEnsalada)

        view.findViewById<View>(R.id.btnSiguienteExtras).setOnClickListener {
            val extras = mutableListOf<String>()
            if (cbBebida.isChecked) extras.add("Bebida")
            if (cbPapas.isChecked) extras.add("Papas")
            if (cbPostre.isChecked) extras.add("Postre")

            val extrasTexto = if (extras.isEmpty()) "Ninguno" else extras.joinToString(", ")

            // Crear ResumenFragment y pasarle todo
            val fragment = ResumenPedidoFragment()
            val bundle = Bundle()
            bundle.putString("comida", comida)
            bundle.putString("extras", extrasTexto)
            fragment.arguments = bundle

            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragment_container, fragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}