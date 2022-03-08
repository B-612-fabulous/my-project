package com.zj.CommunityAnnounce.sercice.impl;
import com.zj.CommunityAnnounce.dao.ICommunityAnnounceDao;
import com.zj.CommunityAnnounce.model.CommunityAnnounceBo;
import com.zj.CommunityAnnounce.sercice.ICommunityAnnounceService;
import com.zj.config.Result.Result;
import com.zj.config.common.GlobalConstant;
import com.zj.config.common.TimeUtil;
import com.zj.config.common.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("communityAccounceService")
public class CommunityAnnounceServiceImpl implements  ICommunityAnnounceService {
    @Autowired
    private ICommunityAnnounceDao communityAnnounceDao;

    @Override
    public Result addICommunityAnnounce1(CommunityAnnounceBo ca) {
        Result r = new Result();
        try {

            ca.setId(UuidUtil.newGeneratId());
            ca.setCreateDate(TimeUtil.getDateTime());
            communityAnnounceDao.addICommunityAnnounce(ca);
             r.setState(GlobalConstant.SUCCE_STATE);
        } catch (Exception e) {
            r.setMsg(GlobalConstant.ERROR_COMMON_MSG);
            r.setState(GlobalConstant.ERROR_STATE);
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public CommunityAnnounceBo selectByid(CommunityAnnounceBo ca) {
        CommunityAnnounceBo ca1=communityAnnounceDao.selectIZByid(ca.getId());
        return ca1;
    }

    @Override
    public Boolean deleteId(CommunityAnnounceBo ca) {
        Integer rows = communityAnnounceDao.deleteCAByid(ca);
         return true;

    }

    @Override
    public Boolean upadteId(CommunityAnnounceBo ca) {

        Result rt = new Result();
        CommunityAnnounceBo ca1 =selectByid(ca);
        if (ca1 != null) {

            rt.setCode(GlobalConstant.LOGIN_NOT_FIND_USER);
            rt.setMsg("用户名不存在");
            return false;

        } else{
            Integer rows = communityAnnounceDao.updateIZByCid(ca1);
            return true;
        }
    }




}
