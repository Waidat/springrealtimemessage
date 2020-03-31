package com.mmessage.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.mmessage.model.ChatMessageModel;

public interface ChatMessageRepository extends MongoRepository<ChatMessageModel,String>, PagingAndSortingRepository<ChatMessageModel,String> {

    List<ChatMessageModel> findAllByOrderByCreatedDateAsc();
}
