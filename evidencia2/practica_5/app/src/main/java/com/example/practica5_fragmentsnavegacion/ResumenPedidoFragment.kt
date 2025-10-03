/*
Descripción: Muestra resumen, Confirmar vuelve al inicio, Editar envía resultado
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
import androidx.fragment.app.setFragmentResult

class ResumenPedidoFragment : Fragment(R.layout.activity_resumen_pedido_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val comida = arguments?.getString("comida") ?: "Desconocida"
        val extras = arguments?.getString("extras") ?: "Ninguno"

        view.findViewById<android.widget.TextView>(R.id.tvComida).text = "Comida: $comida"
        view.findViewById<android.widget.TextView>(R.id.tvExtras).text = "Extras: $extras"

        // Confirmar: volver al inicio (limpiar todo)
        view.findViewById<View>(R.id.btnConfirmar).setOnClickListener {
            Toast.makeText(context, "¡Pedido confirmado!", Toast.LENGTH_SHORT).show()
            // Volver al inicio: quitamos todos los Fragments y ponemos InicioFragment
            activity?.supportFragmentManager?.popBackStack(null, androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragment_container, InicioFragment())
                commit()
            }
        }

        // Editar: enviar datos de regreso y volver a SeleccionComidaFragment
        view.findViewById<View>(R.id.btnEditar).setOnClickListener {
            val resultado = Bundle().apply {
                putString("comida", comida)
                putString("extras", extras)
            }
            setFragmentResult("pedido_editar", resultado)

            // `popBackStack()` hasta el primer Fragment (Inicio), luego vamos a comida
            activity?.supportFragmentManager?.popBackStack(null, androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)

            val fragment = SeleccionComidaFragment()
            val bundle = Bundle()
            bundle.putString("comida", comida)

        }
    }
}