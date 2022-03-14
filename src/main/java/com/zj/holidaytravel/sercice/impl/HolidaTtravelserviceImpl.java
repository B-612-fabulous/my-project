package com.zj.holidaytravel.sercice.impl;
import com.zj.config.Result.Result;
import com.zj.config.common.GlobalConstant;
import com.zj.config.common.TimeUtil;
import com.zj.config.common.UuidUtil;
import com.zj.holidaytravel.dao.IHolidaTtravelDao;
import com.zj.holidaytravel.model.HolidaTtravelBo;
import com.zj.holidaytravel.sercice.IHolidaTtravelservice;
import com.zj.housekeepingservices.dao.IHousekeepingServicesDao;
import com.zj.housekeepingservices.model.HousekeepingServicesBo;
import com.zj.housekeepingservices.sercice.IHousekeepingServiceservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("holidaTtravelservice")
public class HolidaTtravelserviceImpl implements IHolidaTtravelservice {
    @Autowired
    private IHolidaTtravelDao holidaTtravelDao;

    @Override
    public Result addHolidaTtravel(HolidaTtravelBo ht) {

        Result r = new Result();
        try {
            ht.setId(UuidUtil.newGeneratId());
            ht.setIsDelete(0);
            ht.setCreateDate(TimeUtil.getDateTime());
            holidaTtravelDao.addHolidaTtravel(ht);

            r.setState(GlobalConstant.SUCCE_STATE);
        } catch (Exception e) {
            r.setMsg(GlobalConstant.ERROR_COMMON_MSG);
            r.setState(GlobalConstant.ERROR_STATE);
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public Result getHolidaTtravelList(HolidaTtravelBo ht) {
        Result r = new Result();
        try {
            List<IHolidaTtravelDao> htList = holidaTtravelDao.getHolidaTtravelList(ht);
            r.setState(GlobalConstant.SUCCE_STATE);
            r.setData(htList);
        } catch (Exception e) {
            r.setMsg(GlobalConstant.ERROR_COMMON_MSG);
            r.setState(GlobalConstant.ERROR_STATE);
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public Boolean deleteId(HolidaTtravelBo ht) {
                Result rt = new Result();
        Integer rows = holidaTtravelDao.deleteHSByid(ht);
        if (rows == 0) {

            rt.setCode(GlobalConstant.LOGIN_NOT_FIND_USER);
            rt.setMsg("用户名不存在");
            return false;

        } else{
            return true;
        }
    }

    @Override
    public Boolean upadteId(HolidaTtravelBo ht) {
        Result rt = new Result();

        Integer rows1 = holidaTtravelDao.updateHSByid(ht);
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





}
