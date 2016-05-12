package ar.com.gep.websocket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ar.com.gep.websocket.annotation.NotifyClient;
import ar.com.gep.websocket.dto.CommentDTO;
import ar.com.gep.websocket.service.CommentService;

/**
 * 
 * @author Guillermo Pi Dote
 *
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

  @Autowired
  CommentService service;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public @ResponseBody List<CommentDTO> getAll() {
    return service.getAll();
  };

  @NotifyClient(topic = "comment")
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public @ResponseBody CommentDTO update(@PathVariable Integer id, @RequestBody CommentDTO dto) {
    dto.setId(id);
    return service.update(dto);
  }

  @NotifyClient(topic = "comment")
  @RequestMapping(value = "", method = RequestMethod.POST)
  public @ResponseBody CommentDTO save(@RequestBody CommentDTO dto) {
    return service.save(dto);
  }

  @NotifyClient(topic = "comment")
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Integer id) {
    service.delete(id);
  }

  @NotifyClient(topic = "comment")
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public @ResponseBody CommentDTO get(@PathVariable final Integer id) {
    return service.getOne(id);
  }

}
