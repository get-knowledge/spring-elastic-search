package com.getknowledge.elastic.load;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import com.getknowledge.elastic.repository.UsersRepository;

@Component
public class Loaders {

	@Autowired
	ElasticsearchOperations elasticsearchOperations;
	
	@Autowired
	UsersRepository usersRepository;
	
	
	
}
