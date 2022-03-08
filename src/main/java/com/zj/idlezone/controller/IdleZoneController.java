package com.zj.idlezone.controller;
import com.zj.communityVegetables.model.CommunityVegetablesBo;
import com.zj.config.Result.Result;
import com.zj.idlezone.dao.IIdleZoneDao;
import com.zj.idlezone.model.IdleZoneBo;
import com.zj.idlezone.sercice.IIdleZoneService;
import com.zj.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@CrossOrigin
public class IdleZoneController{
    @Autowired
    private IIdleZoneService iIdleZoneService;
    @PostMapping("/iz/addIIdleZone")
    public Result addIIdleZone(@RequestBody IdleZoneBo ib){
        Result rt = null;
        try {
            rt = iIdleZoneService.addIIdleZone(ib);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }

    @PostMapping("/iz/delete")
    public JsonResult<Void> deleteId(@RequestBody IdleZoneBo idleZoneBo) {
        if (iIdleZoneService.deleteId(idleZoneBo)) {
            JsonResult jsonResult = new JsonResult();

            jsonResult.setMessage("");
            jsonResult.setState(10000);
            return jsonResult;
        }
        else {
            JsonResult jsonResult = new JsonResult();

            jsonResult.setMessage("");
            jsonResult.setState(10002);
            return jsonResult;
        }

    }
    @PostMapping("/iz/update")
    public JsonResult<Void> upadteId(@RequestBody IdleZoneBo idleZoneBo) {
        if (iIdleZoneService.upadteId(idleZoneBo)) {
            JsonResult jsonResult = new JsonResult();

            jsonResult.setMessage("");
            jsonResult.setState(10000);
            return jsonResult;
        }
        else {
            JsonResult jsonResult = new JsonResult();

            jsonResult.setMessage("");
            jsonResult.setState(10002);
            return jsonResult;
        }
    }
}
