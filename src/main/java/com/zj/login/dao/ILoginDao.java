package com.zj.login.dao;

import com.zj.login.model.UserBo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginDao {

     UserBo getLogin(UserBo user);

     Integer insert(UserBo user);
     UserBo selectByusername(String username);

}
