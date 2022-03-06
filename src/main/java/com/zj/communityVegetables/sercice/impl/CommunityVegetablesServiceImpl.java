package com.zj.communityVegetables.sercice.impl;

import com.zj.communityVegetables.dao.ICommunityVegetablesDao;
import com.zj.communityVegetables.model.CommunityVegetablesBo;
import com.zj.communityVegetables.sercice.ICommunityVegetablesService;
import com.zj.config.Result.Result;
import com.zj.config.common.GlobalConstant;
import com.zj.config.common.TimeUtil;
import com.zj.config.common.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("communityVegetablesService")
public class CommunityVegetablesServiceImpl implements ICommunityVegetablesService {
    @Autowired
    private ICommunityVegetablesDao communityVegetablesDao;
    @Override
    public Result addCommunityVegetables(CommunityVegetablesBo cb) {
        Result r = new Result();
        try {
            cb.setId(UuidUtil.newGeneratId());
            cb.setIsDelete(0);
            cb.setCreateDate(TimeUtil.getDateTime());
            if(cb.getIsSeckillFlag()==1){
                cb.setSeckill(true);
            }else{
                cb.setSeckill(false);
            }
            communityVegetablesDao.addCommunityVegetables(cb);
            r.setState(GlobalConstant.SUCCE_STATE);
        } catch (Exception e) {
            r.setMsg(GlobalConstant.ERROR_COMMON_MSG);
            r.setState(GlobalConstant.ERROR_STATE);
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public Result getCommunityVegetablesList(CommunityVegetablesBo cb) {
        Result r = new Result();
        try {
            List<CommunityVegetablesBo> cbList = communityVegetablesDao.getCommunityVegetablesList(cb);
            r.setState(GlobalConstant.SUCCE_STATE);
            r.setData(cbList);
        } catch (Exception e) {
            r.setMsg(GlobalConstant.ERROR_COMMON_MSG);
            r.setState(GlobalConstant.ERROR_STATE);
            e.printStackTrace();
        }
        return r;
    }
}
