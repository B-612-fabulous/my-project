package com.zj.housekeepingservices.service.impl;
import com.zj.config.Result.Result;
import com.zj.config.common.GlobalConstant;
import com.zj.config.common.TimeUtil;
import com.zj.config.common.UuidUtil;
import com.zj.housekeepingservices.dao.IHousekeepingServicesDao;
import com.zj.housekeepingservices.model.HousekeepingServicesBo;
import com.zj.housekeepingservices.service.IHousekeepingServiceservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iHousekeepingServiceservice")
public class HousekeepingServiceserviceerviceImpl implements IHousekeepingServiceservice {
    @Autowired
    private IHousekeepingServicesDao iHousekeepingServicesDao;

    @Override
    public Result addHousekeepingServices(HousekeepingServicesBo hs) {

        Result r = new Result();
        try {
            hs.setId(UuidUtil.newGeneratId());
            hs.setIsDelete(0);
            hs.setCreateDate(TimeUtil.getDateTime());
            iHousekeepingServicesDao.addHousekeepingServices(hs);

            r.setState(GlobalConstant.SUCCE_STATE);
        } catch (Exception e) {
            r.setMsg(GlobalConstant.ERROR_COMMON_MSG);
            r.setState(GlobalConstant.ERROR_STATE);
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public Result getHousekeepingServicesList(HousekeepingServicesBo housekeepingServicesBo) {
        Result r = new Result();
        try {
            List<IHousekeepingServicesDao> hsList = iHousekeepingServicesDao.getHousekeepingServicesList(housekeepingServicesBo);
            r.setState(GlobalConstant.SUCCE_STATE);
            r.setData(hsList);
        } catch (Exception e) {
            r.setMsg(GlobalConstant.ERROR_COMMON_MSG);
            r.setState(GlobalConstant.ERROR_STATE);
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public Boolean deleteId(HousekeepingServicesBo housekeepingServicesBo) {
        Result rt = new Result();
//        IdleZoneBo ib1 =selectByid(ib);
        Integer rows = iHousekeepingServicesDao.deleteHSByid(housekeepingServicesBo);
        if (rows == 0) {

            rt.setCode(GlobalConstant.LOGIN_NOT_FIND_USER);
            rt.setMsg("用户名不存在");
            return false;

        } else{
            return true;
        }

    }

    @Override
    public Boolean upadteId(HousekeepingServicesBo housekeepingServicesBo) {
        Result rt = new Result();
//        IdleZoneBo ib1 =selectByid(idleZoneBo);
        Integer rows1 = iHousekeepingServicesDao.updateHSByid(housekeepingServicesBo);
        if (rows1 == 0) {

            rt.setCode(GlobalConstant.LOGIN_NOT_FIND_USER);
            rt.setMsg("用户名不存在");
            return false;

        } else{

            return true;
        }
    }



//    @Override
//    public IdleZoneBo selectByid(IdleZoneBo ib) {
//        IdleZoneBo ib1=  iIdleZoneDao.selectIZByid(ib.getId());
//
//        return ib1;
//    }


//    @Override
//    public Boolean upadteId(IdleZoneBo idleZoneBo) {
//        Result rt = new Result();
//        IdleZoneBo ib1 =selectByid(idleZoneBo);
//        if (ib1 == null) {
//
//            rt.setCode(GlobalConstant.LOGIN_NOT_FIND_USER);
//            rt.setMsg("用户名不存在");
//            return false;
//
//        } else{
//            Integer rows = iIdleZoneDao.updateIZByCid(idleZoneBo);
//            return true;
//        }
//    }


}
