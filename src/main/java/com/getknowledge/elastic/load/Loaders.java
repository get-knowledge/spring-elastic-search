package com.getknowledge.elastic.load;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.getknowledge.elastic.jparepository.UsersJPARepository;
import com.getknowledge.elastic.model.Users;
import com.getknowledge.elastic.repository.UsersRepository;

@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersJPARepository usersJPARepository;
    
    @PostConstruct
    @Transactional
    public void loadAll(){

        operations.putMapping(Users.class);
        System.out.println("Loading Data....");
        List<Users> data = getData();
        usersJPARepository.save(data); // store data in database
        List<Users> lstdata = usersJPARepository.findAll();
        
        usersRepository.save(lstdata); //load data in elasticserch
        System.out.printf("Loading Completed.........");
    }

    private List<Users> getData() {
        List<Users> userses = new ArrayList<>();
        
        userses.add(new Users(123L,"Yogi", "Java Developer", 32000L));
        userses.add(new Users(1234L,"Manoj", "PM", 32000L));
        userses.add(new Users(1235L,"Sagar", "Java Developer", 22000L));
        userses.add(new Users(1235L,"Dhananjy", "IT-Sector", 52000L));
        
        userses.add(new Users(12354L,"Sagar1", "Java Developer", 2207600L));
        userses.add(new Users(12353L,"Dhananjy2", "IT-Sector", 5200670L));
        
        userses.add(new Users(12351L,"Sagar21", "Java Developer", 2204500L));
        userses.add(new Users(12355L,"Dhananjy121", "IT-Sector", 520050L));
        
        userses.add(new Users(12359L,"Sagar1245", "Java Developer", 220030L));
        userses.add(new Users(123501L,"Dhananjy3453", "IT-Sector", 520200L));
        
        return userses;
    }
}