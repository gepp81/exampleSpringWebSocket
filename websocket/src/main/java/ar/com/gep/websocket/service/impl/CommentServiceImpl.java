package ar.com.gep.websocket.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.gep.websocket.dto.CommentDTO;
import ar.com.gep.websocket.entity.Comment;
import ar.com.gep.websocket.repository.CommentRepository;
import ar.com.gep.websocket.service.CommentService;

/**
 * 
 * @author Guillermo Pi Dote
 *
 */
@Service
public class CommentServiceImpl implements CommentService {

  @Autowired
  private CommentRepository repository;

  @Autowired
  private Mapper mapper;

  @Override
  public List<CommentDTO> getAll() {
    List<Comment> entities = repository.findAll();
    List<CommentDTO> dtos = new ArrayList<CommentDTO>();
    for (Comment entity : entities) {
      dtos.add(mapper.map(entity, CommentDTO.class));
    }
    return dtos;
  }

  @Override
  @Transactional
  public CommentDTO save(CommentDTO dto) {
    dto.setDate(Calendar.getInstance().getTime());
    Comment entity = mapper.map(dto, Comment.class);
    mapper.map(repository.saveAndFlush(entity), dto);
    return dto;
  }

  @Override
  @Transactional
  public CommentDTO update(CommentDTO dto) {
    Comment entity = repository.findOne(dto.getId());
    entity.setComment(dto.getComment());
    entity.setTitle(dto.getTitle());
    entity.setDate(Calendar.getInstance().getTime());
    mapper.map(repository.saveAndFlush(entity), dto);
    return dto;
  }

  @Override
  @Transactional
  public void delete(final Integer id) {
    Comment entity = new Comment();
    entity.setId(id);
    repository.delete(entity);
  }

  @Override
  @Transactional
  public CommentDTO getOne(final Integer id) {
    Comment entity = repository.findOne(id);
    return entity == null ? null : mapper.map(entity, CommentDTO.class);
  }

}