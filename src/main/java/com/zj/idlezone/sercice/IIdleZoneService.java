package com.zj.idlezone.sercice;
import com.zj.config.Result.Result;
import com.zj.idlezone.model.IdleZoneBo;

public interface IIdleZoneService {
    Result addIIdleZone(IdleZoneBo idleZoneBo);

//    Result getCommunityVegetablesList(CommunityVegetablesBo cb);
//
    IdleZoneBo selectByid(IdleZoneBo idleZoneBo);

    Boolean deleteId(IdleZoneBo idleZoneBo);
//
   Boolean upadteId(IdleZoneBo idleZoneBo);
}
