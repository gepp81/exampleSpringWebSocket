package ar.com.gep.websocket.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ar.com.gep.websocket.entity.Comment;

/**
 * 
 * @author Guillermo Pi Dote
 *
 */
public interface CommentRepository extends JpaRepository<Comment, Serializable> {
  
  @Query("from Comment where title=:title")
  public List<Comment> findByTitle(@Param("title") String title);

}
