package com.example.practica4_comunicacion

/*
  Descripción: Data class Usuario para enviar entre activities
  Autor: Tu Nombre
  Fecha creación: 2025-09-24
  Fecha última modificación: 2025-09-24
*/

import java.io.Serializable

data class Usuario(
    val nombre: String,
    val edad: Int,
    val ciudad: String,
    val correo: String
) : Serializable

