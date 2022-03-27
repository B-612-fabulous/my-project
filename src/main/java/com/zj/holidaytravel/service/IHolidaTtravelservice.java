package com.zj.holidaytravel.service;
import com.zj.config.Result.Result;
import com.zj.holidaytravel.model.HolidaTtravelBo;

public interface IHolidaTtravelservice {
    Result addHolidaTtravel(HolidaTtravelBo ht);

   Result getHolidaTtravelList(HolidaTtravelBo ht);
//
//    IdleZoneBo selectByid(HolidaTtravelBo ht);
//
   Boolean deleteId(HolidaTtravelBo ht);

  Boolean upadteId(HolidaTtravelBo ht);
}
