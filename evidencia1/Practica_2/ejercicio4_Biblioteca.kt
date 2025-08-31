/**
 * Descripción: Sistema de gestión de biblioteca con Material abstracto, Libro, Revista, Usuario, IBiblioteca y Biblioteca.
 * Autor: Marcelo Vieri Silva Cabrera
 * Fecha creación: 2025-08-31
 * Fecha última modificación: 2025-08-31
 */

abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles(): String
}

class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles(): String {
        return "Libro -> Título: '$titulo', Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numeroPaginas"
    }
}

class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles(): String {
        return "Revista -> Título: '$titulo', Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial"
    }
}

data class Usuario(val nombre: String, val apellido: String, val edad: Int)

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestamo(usuario: Usuario, tituloMaterial: String): Boolean
    fun devolucion(usuario: Usuario, tituloMaterial: String): Boolean
    fun mostrarMaterialesDisponibles(): List<Material>
    fun mostrarMaterialesPrestadosPorUsuario(usuario: Usuario): List<Material>
}

class Biblioteca : IBiblioteca {
    private val disponibles: MutableList<Material> = mutableListOf()
    private val usuarios: MutableSet<Usuario> = mutableSetOf()
    // Map<Usuario, MutableList<Material prestados>>
    private val prestamos: MutableMap<Usuario, MutableList<Material>> = mutableMapOf()

    override fun registrarMaterial(material: Material) {
        disponibles.add(material)
        println("Material registrado: ${material.mostrarDetalles()}")
    }

    override fun registrarUsuario(usuario: Usuario) {
        if (usuarios.add(usuario)) {
            println("Usuario registrado: $usuario")
        } else {
            println("El usuario ya está registrado: $usuario")
        }
    }

    override fun prestamo(usuario: Usuario, tituloMaterial: String): Boolean {
        if (!usuarios.contains(usuario)) {
            println("Usuario no registrado: $usuario")
            return false
        }
        val material = disponibles.find { it.titulo.equals(tituloMaterial, ignoreCase = true) }
        return if (material == null) {
            println("Material no disponible con título: $tituloMaterial")
            false
        } else {
            disponibles.remove(material)
            prestamos.computeIfAbsent(usuario) { mutableListOf() }.add(material)
            println("Préstamo realizado: ${material.mostrarDetalles()} -> Usuario: $usuario")
            true
        }
    }

    override fun devolucion(usuario: Usuario, tituloMaterial: String): Boolean {
        val listaUsuario = prestamos[usuario]
        val material = listaUsuario?.find { it.titulo.equals(tituloMaterial, ignoreCase = true) }
        return if (material == null) {
            println("El usuario no tiene prestado el material con título: $tituloMaterial")
            false
        } else {
            listaUsuario.remove(material)
            if (listaUsuario.isEmpty()) {
                prestamos.remove(usuario)
            }
            disponibles.add(material)
            println("Devolución exitosa: ${material.mostrarDetalles()} <- Usuario: $usuario")
            true
        }
    }

    override fun mostrarMaterialesDisponibles(): List<Material> {
        return disponibles.toList()
    }

    override fun mostrarMaterialesPrestadosPorUsuario(usuario: Usuario): List<Material> {
        return prestamos[usuario]?.toList() ?: emptyList()
    }
}

fun main() {
    val biblioteca = Biblioteca()

    val libro1 = Libro("Sistemas Operativos", "Tanenbaum", 2015, "Informática", 850)
    val libro2 = Libro("Clean Code", "Robert C. Martin", 2008, "Programación", 464)
    val revista1 = Revista("Nature", "Varios", 2021, "0028-0836", 590, 7846, "Nature Publishing Group")

    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(libro2)
    biblioteca.registrarMaterial(revista1)

    val usuario1 = Usuario("María", "Pérez", 22)
    val usuario2 = Usuario("Juan", "Gómez", 30)

    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)

    println("\n--- Estado inicial de materiales disponibles ---")
    biblioteca.mostrarMaterialesDisponibles().forEach { println(it.mostrarDetalles()) }

    println("\n--- Intentando préstamo ---")
    biblioteca.prestamo(usuario1, "Clean Code")
    biblioteca.prestamo(usuario2, "Sistemas Operativos")

    println("\n--- Estado tras préstamos ---")
    println("Disponibles:")
    biblioteca.mostrarMaterialesDisponibles().forEach { println(it.mostrarDetalles()) }
    println("Prestados por María Pérez:")
    biblioteca.mostrarMaterialesPrestadosPorUsuario(usuario1).forEach { println(it.mostrarDetalles()) }

    println("\n--- Devolución ---")
    biblioteca.devolucion(usuario1, "Clean Code")

    println("\n--- Estado final ---")
    biblioteca.mostrarMaterialesDisponibles().forEach { println(it.mostrarDetalles()) }
}
