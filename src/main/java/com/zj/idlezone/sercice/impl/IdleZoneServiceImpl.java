package com.zj.idlezone.sercice.impl;
import com.zj.communityVegetables.model.CommunityVegetablesBo;
import com.zj.config.Result.Result;
import com.zj.config.common.GlobalConstant;
import com.zj.config.common.TimeUtil;
import com.zj.config.common.UuidUtil;
import com.zj.idlezone.dao.IIdleZoneDao;
import com.zj.idlezone.model.IdleZoneBo;
import com.zj.idlezone.sercice.IIdleZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("idleZoneService")
public class IdleZoneServiceImpl implements IIdleZoneService {
    @Autowired
    private IIdleZoneDao iIdleZoneDao;

    @Override
    public Result addIIdleZone(IdleZoneBo ib) {
        Result r = new Result();
                try {
            ib.setId(UuidUtil.newGeneratId());
            ib.setIsDelete(0);
            ib.setCreateDate(TimeUtil.getDateTime());
            iIdleZoneDao.addIIdleZone(ib);

            r.setState(GlobalConstant.SUCCE_STATE);
        } catch (Exception e) {
            r.setMsg(GlobalConstant.ERROR_COMMON_MSG);
            r.setState(GlobalConstant.ERROR_STATE);
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public IdleZoneBo selectByid(IdleZoneBo ib) {
        IdleZoneBo ib1=  iIdleZoneDao.selectIZByid(ib.getId());

        return ib1;
    }

    @Override
    public Boolean deleteId(IdleZoneBo ib) {
        Result rt = new Result();
        IdleZoneBo ib1 =selectByid(ib);
        if (ib1 == null) {

            rt.setCode(GlobalConstant.LOGIN_NOT_FIND_USER);
            rt.setMsg("用户名不存在");
            return false;

        } else{
            Integer rows = iIdleZoneDao.deleteIZByid(ib);
            return true;
        }

    }

    @Override
    public Boolean upadteId(IdleZoneBo idleZoneBo) {
        Result rt = new Result();
        IdleZoneBo ib1 =selectByid(idleZoneBo);
        if (ib1 == null) {

            rt.setCode(GlobalConstant.LOGIN_NOT_FIND_USER);
            rt.setMsg("用户名不存在");
            return false;

        } else{
            Integer rows = iIdleZoneDao.updateIZByCid(idleZoneBo);
            return true;
        }
    }


}
