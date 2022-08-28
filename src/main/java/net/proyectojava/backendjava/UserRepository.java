package net.proyectojava.backendjava;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.proyectojava.backendjava.UserEntities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    
}
    

