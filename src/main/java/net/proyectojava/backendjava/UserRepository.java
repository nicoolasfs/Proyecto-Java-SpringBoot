package net.proyectojava.backendjava;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.proyectojava.backendjava.UserEntities.UserEntity;

@Repository
//Devuelve objetos de lo especificado (UserEntity)
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    public UserEntity findByEmail(String email);
}
    

