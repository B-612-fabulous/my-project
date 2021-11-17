package com.example.store.mapper;

import com.example.store.entity.User;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface Usermapper {
    /**
     * 插入用户的数据
     * @param user 用户数据
     * @return 受影响行数 增删改查
     */
    Integer insert(User user);
    User findByUsername(String username);


}
