import 'package:flutter/material.dart';
import '../models/user.dart';

class UserViewModel extends ChangeNotifier {
  final List<User> _usuarios = [];
  bool _mostrarSoloActivos = false;

  List<User> get usuarios =>
      _mostrarSoloActivos ? _usuarios.where((u) => u.activo).toList() : _usuarios;
  bool get mostrarSoloActivos => _mostrarSoloActivos;

  void filtroActivos(bool value) {
    _mostrarSoloActivos = value;
    notifyListeners();
  }

  void agregarUsuario(User usuario) {
    _usuarios.add(usuario);
    notifyListeners();
  }

  void editarUsuario(int index, User usuario) {
    _usuarios[index] = usuario;
    notifyListeners();
  }

  void eliminarUsuario(int index) {
    _usuarios.removeAt(index);
    notifyListeners();
  }
}
