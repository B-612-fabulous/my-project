package com.zj.holidaytravel.sercice;
import com.zj.config.Result.Result;
import com.zj.holidaytravel.model.HolidaTtravelBo;
import com.zj.housekeepingservices.model.HousekeepingServicesBo;
import com.zj.idlezone.model.IdleZoneBo;

public interface IHolidaTtravelservice {
    Result addHolidaTtravel(HolidaTtravelBo ht);

   Result getHolidaTtravelList(HolidaTtravelBo ht);
//
//    IdleZoneBo selectByid(HolidaTtravelBo ht);
//
   Boolean deleteId(HolidaTtravelBo ht);

  Boolean upadteId(HolidaTtravelBo ht);
}
