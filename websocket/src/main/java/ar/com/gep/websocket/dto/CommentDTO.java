package ar.com.gep.websocket.dto;

import java.util.Date;

/**
 * 
 * @author Guillermo Pi Dote
 *
 */
public class CommentDTO {

  private Integer id;

  private String comment;

  private String title;

  private Date date;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

}
