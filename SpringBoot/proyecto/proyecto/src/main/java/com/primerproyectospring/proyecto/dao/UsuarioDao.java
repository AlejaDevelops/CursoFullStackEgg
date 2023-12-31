package com.primerproyectospring.proyecto.dao;

import com.primerproyectospring.proyecto.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();


    void eliminar(Long id);

    void registrar(Usuario usuario);


    boolean verificarCredenciales(Usuario usuario);
}
