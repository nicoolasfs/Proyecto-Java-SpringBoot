package net.proyectojava.backendjava.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.proyectojava.backendjava.models.request.UserDetailRequestModel;
import net.proyectojava.backendjava.models.responses.UserRest;
import net.proyectojava.backendjava.services.UserServiceInterface;
import net.proyectojava.backendjava.shared.dtos.UserDto;

@RestController
@RequestMapping("/users") //localhost:8080/users
public class UserController {
    
    @Autowired
    UserServiceInterface userService;
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

    
    @PostMapping
    // Un método que recibe un cuerpo de solicitud y devuelve un objeto UserRest.
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetail) {

        //Cuando realizamos una petición Json, Spring nos devuelve un objeto de tipo UserDetailRequestModel, tenemos todos los datos del cliente 

        // Crear una nueva instancia de la clase UserRest y establecer los valores de la instancia en los valores de la instancia de userDetails.
        UserRest returnValue = new UserRest();
        //Creamos objeto DTO para enviarlo a la logica de nuestra aplicación
        UserDto userDto = new UserDto();
        // Copiar los valores de userDetails a userDto -- De un objeto a otro 
        //Se usa para enviar el objeto a la logica
        BeanUtils.copyProperties(userDetail, userDto);
        //Creación para seguridad y tener la aplicación bien organizada y para saber para que se usa cada una de las clases
        UserDto createdUser = userService.createUser(userDto);

        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }
}
