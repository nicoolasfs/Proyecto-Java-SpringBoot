package net.proyectojava.backendjava.services;

import org.springframework.stereotype.Service;

import net.proyectojava.backendjava.shared.dtos.UserDto;

@Service
public class UserService implements UserServiceInterface {
    @Override
    public UserDto createUser(UserDto userDto) {
        return userDto;
    }
}
    
