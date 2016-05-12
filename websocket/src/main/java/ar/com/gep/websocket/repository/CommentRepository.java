package ar.com.gep.websocket.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.gep.websocket.entity.Comment;

/**
 * 
 * @author Guillermo Pi Dote
 *
 */
public interface CommentRepository extends JpaRepository<Comment, Serializable> {

}
