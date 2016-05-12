package ar.com.gep.websocket.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ar.com.gep.websocket.dto.CommentDTO;

/**
 * 
 * @author Guillermo Pi Dote
 *
 */
public interface CommentService {

  List<CommentDTO> getAll();

  @Transactional
  CommentDTO save(CommentDTO dto);

  Boolean exists(final CommentDTO dto);

  @Transactional
  CommentDTO update(CommentDTO dto);

  @Transactional
  void delete(final Integer id);

  @Transactional
  CommentDTO getOne(final Integer id);

}
