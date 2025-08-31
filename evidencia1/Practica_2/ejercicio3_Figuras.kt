/**
 * Descripción: Jerarquía de figuras geométricas (Shape) y subclases Cuadrado, Rectángulo, Círculo.
 * Autor: Marcelo Vieri Silva Cabrera
 * Fecha creación: 2025-08-31
 * Fecha última modificación: 2025-08-31
 */

import kotlin.math.PI
import kotlin.math.pow

abstract class Shape {
    var area: Double = 0.0
        protected set
    var perimetro: Double = 0.0
        protected set

    abstract fun calcularArea()
    abstract fun calcularPerimetro()

    fun imprimirResultados() {
        println("Área: ${"%.4f".format(area)}")
        println("Perímetro: ${"%.4f".format(perimetro)}")
    }
}

class Cuadrado(private val lado: Double) : Shape() {
    override fun calcularArea() {
        area = lado * lado
    }

    override fun calcularPerimetro() {
        perimetro = 4 * lado
    }
}

class Rectangulo(private val base: Double, private val altura: Double) : Shape() {
    override fun calcularArea() {
        area = base * altura
    }

    override fun calcularPerimetro() {
        perimetro = 2 * (base + altura)
    }
}

class Circulo private constructor(private val radio: Double) : Shape() {

    // Constructor secundario que recibe el diámetro
    constructor(diametro: Double, usarDiametro: Boolean = true) : this(diametro / 2.0)

    override fun calcularArea() {
        area = PI * radio.pow(2)
    }

    override fun calcularPerimetro() {
        perimetro = 2 * PI * radio
    }
}

fun main() {
    val cuadrado = Cuadrado(4.0)
    cuadrado.calcularArea()
    cuadrado.calcularPerimetro()
    println("Cuadrado (lado=4.0)")
    cuadrado.imprimirResultados()
    println()

    val rectangulo = Rectangulo(5.0, 3.0)
    rectangulo.calcularArea()
    rectangulo.calcularPerimetro()
    println("Rectángulo (base=5.0, altura=3.0)")
    rectangulo.imprimirResultados()
    println()

    val circulo = Circulo(10.0) // usa el constructor secundario (diámetro)
    circulo.calcularArea()
    circulo.calcularPerimetro()
    println("Círculo (diámetro=10.0)")
    circulo.imprimirResultados()
}
