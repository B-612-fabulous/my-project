package com.zj.idlezone.dao;
import com.zj.idlezone.model.IdleZoneBo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIdleZoneDao {

    void addIIdleZone(IdleZoneBo ib);

    IdleZoneBo selectIZByid(String id);

    Integer deleteIZByid(IdleZoneBo ib);
    Integer updateIZByCid(IdleZoneBo ib);





}
