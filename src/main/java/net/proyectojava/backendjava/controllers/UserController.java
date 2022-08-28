package net.proyectojava.backendjava.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users") //localhost:8080/users
public class UserController {
    
    /**
     * Esta función devuelve una cadena "obtener detalles del usuario" cuando se realiza una solicitud
     * GET al punto final /usuario
     * 
     * @return Un string
     */
    @GetMapping
    public String getUser() {
        return "get user details";
    }

    /**
     * Esta función se llama cuando se realiza una solicitud POST al punto final /users
     * 
     * @return Un string 
     */
    @PostMapping
    public String createUser() {
        return "create new user";
    }
}
