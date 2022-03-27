package com.zj.communityAnnounce.service;
import com.zj.communityAnnounce.model.CommunityAnnounceBo;
import com.zj.config.Result.Result;
public interface ICommunityAnnounceService {
    Result addICommunityAnnounce1(CommunityAnnounceBo ca);

  Result getCommunityAnnounceList(CommunityAnnounceBo ca);
  Result selectByid(CommunityAnnounceBo ca);
  Boolean deleteId(CommunityAnnounceBo ca);
  Boolean upadteId(CommunityAnnounceBo ca);
}
