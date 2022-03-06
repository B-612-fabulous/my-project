package com.zj.communityVegetables.dao;

import com.zj.communityVegetables.model.CommunityVegetablesBo;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommunityVegetablesDao {
    void addCommunityVegetables(CommunityVegetablesBo cb);
}
