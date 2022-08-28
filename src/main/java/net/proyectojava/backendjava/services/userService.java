package net.proyectojava.backendjava.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.proyectojava.backendjava.UserRepository;
import net.proyectojava.backendjava.UserEntities.UserEntity;
import net.proyectojava.backendjava.shared.dtos.UserDto;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Override
    // Un método que guarda usuarios, se llama desde el controlador.
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);

        userEntity.setEncriptedpassword("Test");
        userEntity.setUserId("TestID");

        UserEntity storedUserDetails = userRepository.save(userEntity);
        
        userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);


        return returnValue;
    }
}
    
