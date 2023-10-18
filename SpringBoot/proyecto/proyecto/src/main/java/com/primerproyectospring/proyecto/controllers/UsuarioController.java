package com.primerproyectospring.proyecto.controllers;

import com.primerproyectospring.proyecto.dao.UsuarioDao;
import com.primerproyectospring.proyecto.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Alejandra");
        usuario.setApellido("Orjuela");
        usuario.setEmail("orjuela.alejandrap@gmail.com");
        usuario.setTelefono("302 5144232");
        usuario.setPassword("123456789");


        return usuario;
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "usuario123")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Alejandra");
        usuario.setApellido("Orjuela");
        usuario.setEmail("orjuela.alejandrap@gmail.com");
        usuario.setTelefono("302 5144232");
        usuario.setPassword("123456789");

        return usuario;
    }

    @RequestMapping(value = "usuario1234")
    public Usuario eliminar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Alejandra");
        usuario.setApellido("Orjuela");
        usuario.setEmail("orjuela.alejandrap@gmail.com");
        usuario.setTelefono("302 5144232");
        usuario.setPassword("123456789");

        return usuario;
    }

    @RequestMapping(value = "usuario12345")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Alejandra");
        usuario.setApellido("Orjuela");
        usuario.setEmail("orjuela.alejandrap@gmail.com");
        usuario.setTelefono("302 5144232");
        usuario.setPassword("123456789");

        return usuario;
    }




}
