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
@RequestMapping(CommentController.COMMENT_URL)
public class CommentController {

  private static final String EMPTY = "";
  private static final String ID = "/{id}";
  private static final String COMMENT = "comment";
  public static final String COMMENT_URL = "/comment";

  @Autowired
  CommentService service;

  @RequestMapping(value = EMPTY, method = RequestMethod.GET)
  public @ResponseBody List<CommentDTO> getAll() {
    return service.getAll();
  };

  @NotifyClient(topic = COMMENT, action = "update")
  @RequestMapping(value = ID, method = RequestMethod.PUT)
  public @ResponseBody CommentDTO update(@PathVariable Integer id, @RequestBody CommentDTO dto) {
    dto.setId(id);
    return service.update(dto);
  }

  @NotifyClient(topic = COMMENT, action = "save")
  @RequestMapping(value = EMPTY, method = RequestMethod.POST)
  public @ResponseBody CommentDTO save(@RequestBody CommentDTO dto) {
    return service.save(dto);
  }

  @NotifyClient(topic = COMMENT, action = "delete")
  @RequestMapping(value = ID, method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Integer id) {
    service.delete(id);
  }

  @RequestMapping(value = ID, method = RequestMethod.GET)
  public @ResponseBody CommentDTO get(@PathVariable final Integer id) {
    return service.getOne(id);
  }

}
