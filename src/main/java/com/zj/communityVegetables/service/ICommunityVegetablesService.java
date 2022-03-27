package com.zj.communityVegetables.service;

import com.zj.communityVegetables.model.CommunityVegetablesBo;
import com.zj.config.Result.Result;

public interface ICommunityVegetablesService {
    Result addCommunityVegetables(CommunityVegetablesBo cb);

    Result getCommunityVegetablesList(CommunityVegetablesBo cb);

    CommunityVegetablesBo selectByid(CommunityVegetablesBo cb);

    Boolean deleteId(CommunityVegetablesBo cb);

    Boolean upadteId(CommunityVegetablesBo cb);
}
