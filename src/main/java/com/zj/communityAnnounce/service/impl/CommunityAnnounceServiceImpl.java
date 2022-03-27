package com.zj.communityAnnounce.service.impl;
import com.zj.communityAnnounce.dao.ICommunityAnnounceDao;
import com.zj.communityAnnounce.model.CommunityAnnounceBo;
import com.zj.communityAnnounce.service.ICommunityAnnounceService;
import com.zj.communityVegetables.model.CommunityVegetablesBo;
import com.zj.config.Result.Result;
import com.zj.config.common.GlobalConstant;
import com.zj.config.common.TimeUtil;
import com.zj.config.common.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Result getCommunityAnnounceList(CommunityAnnounceBo ca) {
        Result r = new Result();
        try {
            List<CommunityVegetablesBo> caList = communityAnnounceDao.getCommunityAnnounceList(ca);
            r.setState(GlobalConstant.SUCCE_STATE);
            r.setData(caList);
        } catch (Exception e) {
            r.setMsg(GlobalConstant.ERROR_COMMON_MSG);
            r.setState(GlobalConstant.ERROR_STATE);
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public Result selectByid(CommunityAnnounceBo ca) {
        Result r = new Result();
        try {
            List<CommunityVegetablesBo> caList = communityAnnounceDao.selectIZByid(ca);
            r.setState(GlobalConstant.SUCCE_STATE);
            r.setData(caList);
        } catch (Exception e) {
            r.setMsg(GlobalConstant.ERROR_COMMON_MSG);
            r.setState(GlobalConstant.ERROR_STATE);
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public Boolean deleteId(CommunityAnnounceBo ca) {
        Result r = new Result();

//       communityAnnounceDao.selectByid(ca);
        Integer rows = communityAnnounceDao.deleteCAByid(ca);
        if (rows==1){
            return true;
        }
        else {
            return false;
        }


    }

    @Override
    public Boolean upadteId(CommunityAnnounceBo ca) {

//        Result rt = new Result();
//        CommunityAnnounceBo ca1 =selectByid(ca);
//        if (ca1 != null) {
//
//            rt.setCode(GlobalConstant.LOGIN_NOT_FIND_USER);
//            rt.setMsg("用户名不存在");
//            return false;
//
//        } else{
            Integer rows = communityAnnounceDao.updateIZByCid(ca);
            return true;
//        }
    }




}
