import 'package:flutter/material.dart';

class PantallaHobbies extends StatelessWidget {
  const PantallaHobbies({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Mis Hobbies'),
        backgroundColor: Colors.red,
        centerTitle: true,
      ),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            hobbyItem('Leer libros', 'https://cdn-icons-png.flaticon.com/512/29/29302.png'),
            hobbyItem('Jugar videojuegos', 'https://cdn-icons-png.flaticon.com/512/686/686589.png'),
            hobbyItem('Escuchar música', 'https://cdn-icons-png.flaticon.com/512/727/727218.png'),

          ],
        ),
      ),
    );
  }

  Widget hobbyItem(String titulo, String urlImagen) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 10),
      child: Row(
        children: [
          Image.network(urlImagen, width: 50, height: 50),
          const SizedBox(width: 20),
          Text(
            titulo,
            style: const TextStyle(fontSize: 18, fontWeight: FontWeight.w500),
          ),
        ],
      ),
    );
  }
}
