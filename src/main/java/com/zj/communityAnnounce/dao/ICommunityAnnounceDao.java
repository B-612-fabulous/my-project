package com.zj.communityAnnounce.dao;
import com.zj.communityAnnounce.model.CommunityAnnounceBo;
import com.zj.communityVegetables.model.CommunityVegetablesBo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommunityAnnounceDao {

    void addICommunityAnnounce(CommunityAnnounceBo ca);
    List<CommunityVegetablesBo> getCommunityAnnounceList(CommunityAnnounceBo ca);
    List<CommunityVegetablesBo> selectIZByid(CommunityAnnounceBo ca);

   Integer deleteCAByid(CommunityAnnounceBo ca);
   Integer updateIZByCid(CommunityAnnounceBo ca);





}
