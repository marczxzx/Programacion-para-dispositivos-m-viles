/**
 * Descripción: Clase CuentaBancaria con saldo, límite de retiro, getters y setters, y método para retirar.
 * Autor: Marcelo Vieri Silva Cabrera
 * Fecha creación: 2025-08-31
 * Fecha última modificación: 2025-08-31
 */

class CuentaBancaria(saldoInicial: Double, limiteRetiroInicial: Double) {
    var saldo: Double = 0.0
        set(value) {
            if (value < 0.0) {
                println("Valor inválido para saldo. Se mantiene el valor anterior: \$${field}")
            } else {
                field = value
            }
        }

    var limiteRetiro: Double = 0.0
        set(value) {
            if (value < 0.0) {
                println("Valor inválido para límite de retiro. Se mantiene el valor anterior: \$${field}")
            } else {
                field = value
            }
        }

    init {
        saldo = saldoInicial
        limiteRetiro = limiteRetiroInicial
    }

    fun retirar(cantidad: Double): Boolean {
        return when {
            cantidad <= 0.0 -> {
                println("La cantidad a retirar debe ser mayor que 0.")
                false
            }
            cantidad > limiteRetiro -> {
                println("La cantidad supera el límite de retiro (\$${limiteRetiro}).")
                false
            }
            cantidad > saldo -> {
                println("Fondos insuficientes. Saldo actual: \$${saldo}.")
                false
            }
            else -> {
                saldo -= cantidad
                println("Retiro exitoso: \$${cantidad}. Saldo restante: \$${saldo}.")
                true
            }
        }
    }
}

fun main() {
    val cuenta = CuentaBancaria(1000.0, 500.0)
    println("Saldo inicial: \$${cuenta.saldo}")
    cuenta.retirar(600.0)   // excede límite
    cuenta.retirar(400.0)   // ok
    cuenta.saldo = -50.0    // validación en set
    println("Saldo final: \$${cuenta.saldo}")
}
