package com.primerproyectospring.proyecto.controllers;

import com.primerproyectospring.proyecto.dao.UsuarioDao;
import com.primerproyectospring.proyecto.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
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

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuarios(@RequestBody Usuario usuario){
        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        usuarioDao.eliminar(id);
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
