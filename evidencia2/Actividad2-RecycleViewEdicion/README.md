\# 📖 Práctica: RecyclerView con Edición y Long Click



\## 🔹 Introducción



El \*\*RecyclerView\*\* es un componente de Android muy útil para mostrar listas grandes de manera optimizada.  

Cada elemento de la lista se administra con un `ViewHolder`, mientras que un `Adapter` se encarga de conectar los datos con las vistas.



---



\## 🎯 Objetivos



1\. Detectar un \*\*long click\*\* sobre un ítem del `RecyclerView`.  

2\. Mostrar un \*\*menú de opciones\*\* con `AlertDialog` (Editar o Eliminar).  

3\. Implementar un \*\*diálogo personalizado\*\* para modificar un usuario (nombre, edad, correo).  

4\. Actualizar el listado usando `notifyItemChanged()`.



---



\## 💡 Diálogos en Android



Un \*\*diálogo\*\* es una ventana emergente que aparece sobre la pantalla actual.  

Sirve para mostrar mensajes, confirmar acciones o pedir información al usuario sin tener que cambiar de pantalla.



\### Ejemplo de `AlertDialog` en Kotlin:



```kotlin

AlertDialog.Builder(this)

&nbsp;   .setTitle("Aviso")

&nbsp;   .setMessage("¿Quieres continuar con la acción?")

&nbsp;   .setPositiveButton("Aceptar") { \_, \_ ->

&nbsp;       // Acción cuando el usuario acepta

&nbsp;   }

&nbsp;   .setNegativeButton("Cancelar", null)

&nbsp;   .show()



