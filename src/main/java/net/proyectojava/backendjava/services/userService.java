package net.proyectojava.backendjava.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.proyectojava.backendjava.UserRepository;
import net.proyectojava.backendjava.UserEntities.UserEntity;
import net.proyectojava.backendjava.shared.dtos.UserDto;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    // Un método que guarda usuarios, se llama desde el controlador.
    public UserDto createUser(UserDto userDto) {

        // Comprobando si el usuario ya existe en la base de datos.
        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new RuntimeException("Este usuario ya está registrado...");
        }

       // Copiando las propiedades de userDto a userEntity.
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);

       // Cifrado de la contraseña del usuario.
        userEntity.setEncriptedpassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
     
        // Generar un UUID aleatorio y establecerlo como ID de usuario.
        UUID userId = UUID.randomUUID();
        userEntity.setUserId(userId.toString());

        UserEntity storedUserDetails = userRepository.save(userEntity);
        
        userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);


        return returnValue;
    }
}
    
