/*
Descripción: Fragment inicial con botón "Nuevo pedido".
Autor: Davis Arapa
Fecha creación: 01-01-2025
Fecha última modificación: 01-01-2025
*/

package com.example.practica5_fragmentsnavegacion

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class InicioFragment : Fragment(R.layout.activity_inicio_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.btnNuevoPedido).setOnClickListener {
            // Navegar a SeleccionComidaFragment
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragment_container, SeleccionComidaFragment())
                addToBackStack(null)  // permite volver con el botón "Atrás"
                commit()
            }
        }
    }
}