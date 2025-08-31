/**
 * Descripción: Clase Producto con precio y descuento; cálculo del precio final.
 * Autor: Marcelo Vieri Silva Cabrera
 * Fecha creación: 2025-08-31
 * Fecha última modificación: 2025-08-31
 */

class Producto(precioInicial: Double, descuentoInicial: Double) {
    var precio: Double = 0.0
        set(value) {
            if (value < 0.0) {
                println("Precio inválido. Se mantiene el valor anterior: \$${field}")
            } else {
                field = value
            }
        }

    // descuento en porcentaje (0.0 .. 100.0)
    var descuento: Double = 0.0
        set(value) {
            if (value < 0.0 || value > 100.0) {
                println("Descuento inválido. Debe estar entre 0 y 100. Se mantiene: ${field}%")
            } else {
                field = value
            }
        }

    init {
        precio = precioInicial
        descuento = descuentoInicial
    }

    fun precioFinal(): Double {
        return precio * (1 - descuento / 100.0)
    }
}

fun main() {
    val p = Producto(150.0, 10.0)
    println("Precio base: \$${p.precio}")
    println("Descuento: ${p.descuento}%")
    println("Precio final: \$${"%.2f".format(p.precioFinal())}")

    p.descuento = 150.0   // validación en set
    p.precio = -20.0      // validación en set
    println("Estado final -> precio: \$${p.precio}, descuento: ${p.descuento}%")
}
