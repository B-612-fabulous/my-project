package com.example.store.mapper;

import com.example.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired
    private Usermapper usermapper;

    @Test
    public void insert(){
        User user=new User();
        user.setUsername("ttim");
        user.setPassword("123");
        Integer rows=usermapper.insert(user);
        System.out.println(rows);

    }
    @Test
    public void findByUsername(){
        User user=usermapper.findByUsername("ttim");
        System.out.println(user);
    }

}
