package com.zj.housekeepingservices.controller;
import com.zj.config.Result.Result;
import com.zj.housekeepingservices.model.HousekeepingServicesBo;
import com.zj.housekeepingservices.service.IHousekeepingServiceservice;
import com.zj.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class HousekeepingServicesController {
    @Autowired
    private IHousekeepingServiceservice iHousekeepingServiceservice;

    @PostMapping("/getHousekeepingServicesList")
    public Result getIdleZoneList(@RequestBody HousekeepingServicesBo housekeepingServicesBo) {
        Result rt = null;
        try {
            rt = iHousekeepingServiceservice.getHousekeepingServicesList(housekeepingServicesBo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }


    @PostMapping("/addHousekeepingServices")
    public Result addHousekeepingServices(@RequestBody HousekeepingServicesBo housekeepingServicesBo){
        Result rt = null;
        try {
            rt = iHousekeepingServiceservice.addHousekeepingServices(housekeepingServicesBo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }

    @PostMapping("/deleteHousekeepingServices")
    public JsonResult<Void> deleteHousekeepingServices(@RequestBody HousekeepingServicesBo housekeepingServicesBo) {
        if (iHousekeepingServiceservice.deleteId(housekeepingServicesBo)) {
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
    @PostMapping("/upadteIdHousekeepingServices")
    public JsonResult<Void> upadteIdHousekeepingServices(@RequestBody HousekeepingServicesBo housekeepingServicesBo) {
        if (iHousekeepingServiceservice.upadteId(housekeepingServicesBo)) {
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
