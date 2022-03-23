package com.zj.login.dao;
import com.zj.login.model.UserBo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILoginDao {

     UserBo getLogin(UserBo user);
     List<UserBo> getUserList(UserBo user);
     Integer insert(UserBo user);
     UserBo selectByusername(String username);

     Integer deleteByid(UserBo user);
     Integer updateByid(UserBo userBo);
     Integer updateByUserName(UserBo userBo);

}
