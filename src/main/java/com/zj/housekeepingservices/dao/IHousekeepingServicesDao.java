package com.zj.housekeepingservices.dao;
import com.zj.housekeepingservices.model.HousekeepingServicesBo;
import com.zj.idlezone.model.IdleZoneBo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHousekeepingServicesDao {

    List<IHousekeepingServicesDao> getHousekeepingServicesList(HousekeepingServicesBo hs);

    void addHousekeepingServices(HousekeepingServicesBo hs);


//    IdleZoneBo selectIZByid(String id);
//
    Integer deleteHSByid(HousekeepingServicesBo hs);
    Integer updateHSByid(HousekeepingServicesBo hs);





}
