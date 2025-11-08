import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

// Pantalla principal que muestra los hobbies
class PantallaHobbies extends StatelessWidget {
  const PantallaHobbies({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // Barra superior con título y color personalizado
      appBar: AppBar(
        title: const Text("Mis Hobbies"),
        backgroundColor: Colors.orange,
      ),
      body: Padding(
        // Espaciado alrededor del contenido
        padding: const EdgeInsets.all(20),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Primer hobby: leer libros
            Row(
              children: const [
                Icon(
                    Icons.book,
                    color: Colors.deepPurple
                ),
                SizedBox(width: 10),
                Text("Leer libros de tecnología y desarrollo personal"),
              ],
            ),
            const SizedBox(height: 10),
            // Segundo hobby: jugar videojuegos
            Row(
              children: const [
                Icon(
                    Icons.sports_esports,
                    color: Colors.teal
                ),
                SizedBox(width: 10),
                Text("Jugar videojuegos con mis amigos"),
              ],
            ),
            const SizedBox(height: 10),
            // Tercer hobby: escuchar música
            Row(
              children: const [
                Icon(
                    Icons.music_note,
                    color: Colors.redAccent
                ),
                SizedBox(width: 10),
                Text("Escuchar música y descubrir nuevos artistas"),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
