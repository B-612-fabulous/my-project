package com.zj.holidaytravel.dao;
import com.zj.holidaytravel.model.HolidaTtravelBo;
import com.zj.housekeepingservices.model.HousekeepingServicesBo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHolidaTtravelDao {

    List<IHolidaTtravelDao> getHolidaTtravelList(HolidaTtravelBo holidaTtravelBo);

    void addHolidaTtravel(HolidaTtravelBo holidaTtravelBo);


//    IdleZoneBo selectIZByid(String id);
    Integer deleteHSByid(HolidaTtravelBo holidaTtravelBo);
    Integer updateHSByid(HolidaTtravelBo holidaTtravelBo);





}
