package com.primerproyectospring.proyecto.controllers;

import com.primerproyectospring.proyecto.dao.UsuarioDao;
import com.primerproyectospring.proyecto.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;


    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){


        if (usuarioDao.verificarCredenciales(usuario)){
            return "OK";
        }
        return "FAIL";
    }
}
