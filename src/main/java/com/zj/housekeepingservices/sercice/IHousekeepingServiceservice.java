package com.zj.housekeepingservices.sercice;
import com.zj.config.Result.Result;
import com.zj.housekeepingservices.model.HousekeepingServicesBo;
import com.zj.idlezone.model.IdleZoneBo;

public interface IHousekeepingServiceservice {
    Result addHousekeepingServices(HousekeepingServicesBo housekeepingServicesBo);

    Result getHousekeepingServicesList(HousekeepingServicesBo housekeepingServicesBo);
//
//    IdleZoneBo selectByid(IdleZoneBo idleZoneBo);
//
    Boolean deleteId(HousekeepingServicesBo housekeepingServicesBo);
//
  Boolean upadteId(HousekeepingServicesBo housekeepingServicesBo);
}
