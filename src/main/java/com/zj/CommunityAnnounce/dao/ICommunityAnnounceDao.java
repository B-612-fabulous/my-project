package com.zj.CommunityAnnounce.dao;
import com.zj.CommunityAnnounce.model.CommunityAnnounceBo;
import com.zj.communityVegetables.model.CommunityVegetablesBo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommunityAnnounceDao {

    void addICommunityAnnounce(CommunityAnnounceBo ca);
    List<CommunityVegetablesBo> getCommunityAnnounceList(CommunityAnnounceBo ca);
    CommunityAnnounceBo selectIZByid(String id);

   Integer deleteCAByid(CommunityAnnounceBo ca);
   Integer updateIZByCid(CommunityAnnounceBo ca);





}