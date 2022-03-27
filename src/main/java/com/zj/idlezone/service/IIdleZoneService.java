package com.zj.idlezone.service;
import com.zj.config.Result.Result;
import com.zj.idlezone.model.IdleZoneBo;

public interface IIdleZoneService {
    Result addIIdleZone(IdleZoneBo idleZoneBo);

  Result getIdleZoneList(IdleZoneBo idleZoneBo);
//
    IdleZoneBo selectByid(IdleZoneBo idleZoneBo);

    Boolean deleteId(IdleZoneBo idleZoneBo);
//
   Boolean upadteId(IdleZoneBo idleZoneBo);
}
