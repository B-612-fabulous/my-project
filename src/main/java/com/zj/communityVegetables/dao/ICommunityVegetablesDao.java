package com.zj.communityVegetables.dao;

import com.zj.communityVegetables.model.CommunityVegetablesBo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommunityVegetablesDao {
    void addCommunityVegetables(CommunityVegetablesBo cb);

    List<CommunityVegetablesBo> getCommunityVegetablesList(CommunityVegetablesBo cb);

    CommunityVegetablesBo selectByid(String id);

    Integer deleteByid(CommunityVegetablesBo cb);

    Integer updateByCid(CommunityVegetablesBo cb);



}
