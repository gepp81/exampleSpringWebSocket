package ar.com.gep.websocket.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.gep.websocket.entity.security.User;

/**
 * 
 * @author Guillermo Pi Dote
 */
public interface UserRepository extends JpaRepository<User, Serializable> {

  User findByUsername(final String username);

}
