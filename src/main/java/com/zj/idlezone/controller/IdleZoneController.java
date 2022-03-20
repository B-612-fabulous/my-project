package com.zj.idlezone.controller;
import com.zj.config.Result.Result;
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

    @PostMapping("/getIdleZoneList")
    public Result getIdleZoneList(@RequestBody IdleZoneBo ib) {
        Result rt = null;
        try {
            rt = iIdleZoneService.getIdleZoneList(ib);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }


    @PostMapping("/addIIdleZone")
    public Result addIIdleZone(@RequestBody IdleZoneBo ib){
        Result rt = null;
        try {
            rt = iIdleZoneService.addIIdleZone(ib);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }

    @PostMapping("/deleteIdleZone")
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
    @PostMapping("/updateIdleZone")
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
