package com.example.store.service;

import com.example.store.entity.User;
import com.example.store.mapper.Usermapper;
import com.example.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    private IUserService UserService;

    @Test
    public void reg(){
        try {
            User user=new User();
            user.setUsername("ttim21");
            user.setPassword("123");
            UserService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            //获取异常具体描述信息
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void  login(){
      User user=  UserService.login("ttim21","123");
      System.out.println(user);
    }


}
