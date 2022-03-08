package com.zj.CommunityAnnounce.dao;
import com.zj.CommunityAnnounce.model.CommunityAnnounceBo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommunityAnnounceDao {

    void addICommunityAnnounce(CommunityAnnounceBo ca);

    CommunityAnnounceBo selectIZByid(String id);

   Integer deleteCAByid(CommunityAnnounceBo ca);
  Integer updateIZByCid(CommunityAnnounceBo ca);





}
