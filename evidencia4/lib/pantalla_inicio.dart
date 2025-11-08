import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

// Pantalla principal de inicio de la aplicación
class PantallaInicio extends StatelessWidget {
  const PantallaInicio({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // Barra superior con título, color personalizado y acciones adicionales
      appBar: AppBar(
        title: const Text("Pantalla Inicio"),
        backgroundColor: Colors.indigo,
        centerTitle: true, // Centra el título en la barra de la app
        actions: const [
          // Icono de configuración en la parte derecha
          Icon(Icons.settings),
          SizedBox(width: 12),
          // Icono de agregar en la parte derecha
          Icon(Icons.add),
        ],
      ),
      body: Center(
        // Centra el contenido del cuerpo
        child: Padding(
          padding: const EdgeInsets.all(16),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center, // Centra los elementos verticalmente
            children: [
              // Texto de bienvenida con estilo personalizado
              const Text(
                "Bienvenido a mi aplicación personal",
                style: TextStyle(
                  fontSize: 20,
                  fontWeight: FontWeight.bold,
                  color: Colors.indigo,
                ),
                textAlign: TextAlign.center, // Centra el texto
              ),
              const SizedBox(height: 30),
              // Botón para ir al perfil (sin funcionalidad definida por el momento)
              ElevatedButton(
                onPressed: () {},
                child: const Text("Ver mi perfil"),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
