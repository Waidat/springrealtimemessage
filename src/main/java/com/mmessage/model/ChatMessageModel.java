package com.mmessage.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document
public class ChatMessageModel {

    @Id
     private String id;

     @Indexed(name = "text")
     private String text;
     private String author;
     private Date createdDate;

 public ChatMessageModel(String text, String author, Date createdDate) {
  this.text = text;
  this.author = author;
  this.createdDate = createdDate;
 }
}
