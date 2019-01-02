package com.getknowledge.elastic.load;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.getknowledge.elastic.model.Users;
import com.getknowledge.elastic.repository.UsersRepository;

@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    UsersRepository usersRepository;

    @PostConstruct
    @Transactional
    public void loadAll(){

        operations.putMapping(Users.class);
        System.out.println("Loading Data....");
        usersRepository.save(getData());
        System.out.printf("Loading Completed.........");
    }

    private List<Users> getData() {
        List<Users> userses = new ArrayList<>();
        userses.add(new Users(123L,"Ajay", "Accounting", 12000L));
        userses.add(new Users(1234L,"Jaga", "Finance", 22000L));
        userses.add(new Users(1235L,"Thiru", "Accounting", 12000L));
        return userses;
    }
}