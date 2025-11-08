import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

// Pantalla que muestra el perfil de usuario
class PantallaPerfil extends StatelessWidget {
  const PantallaPerfil({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // Barra superior con título y color personalizado
      appBar: AppBar(
        title: const Text('Mi Perfil'),
        backgroundColor: Colors.green,
      ),
      body: SingleChildScrollView(
        // Permite desplazarse por el contenido si es necesario
        padding: const EdgeInsets.all(20),
        child: Column(
          children: [
            // Foto de perfil circular
            const CircleAvatar(
              radius: 60,
              backgroundImage: NetworkImage(
                'https://cdn-icons-png.flaticon.com/512/147/147144.png',
              ),
            ),
            const SizedBox(height: 20),
            // Nombre del usuario
            const Text(
              'Davis Yovanny Arapa Chua',
              style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
            ),
            // Descripción del usuario (profesión)
            const Text(
              'Estudiante de Ingeniería de Software',
              style: TextStyle(fontSize: 16, color: Colors.grey),
            ),

            const SizedBox(height: 10),
            // Fila con icono de email y correo del usuario
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: const [
                Icon(
                    Icons.email,
                    color: Colors.blueAccent
                ),
                SizedBox(width: 8),
                Text('darapac@ulasalle.edu.pe'),
              ],
            ),
            const SizedBox(height: 10),
            // Fila con icono de teléfono y número de contacto
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: const [
                Icon(
                    Icons.phone,
                    color: Colors.green
                ),
                SizedBox(width: 8),
                Text('+51 948 224 688'),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
