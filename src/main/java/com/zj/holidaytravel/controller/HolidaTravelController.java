package com.zj.holidaytravel.controller;
import com.zj.config.Result.Result;
import com.zj.holidaytravel.model.HolidaTtravelBo;
import com.zj.holidaytravel.service.IHolidaTtravelservice;
import com.zj.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class HolidaTravelController {
    @Autowired
    private IHolidaTtravelservice holidaTtravelservice;

    @PostMapping("/getHolidaTtravelList")
    public Result getHolidaTtravelList(@RequestBody HolidaTtravelBo holidaTtravelBo) {
        Result rt = null;
        try {
            rt = holidaTtravelservice.getHolidaTtravelList(holidaTtravelBo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }


    @PostMapping("/addHolidaTtravel")
    public Result addHolidaTtravel(@RequestBody HolidaTtravelBo holidaTtravelBo){
        Result rt = null;
        try {
            rt = holidaTtravelservice.addHolidaTtravel(holidaTtravelBo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }

    @PostMapping("/deleteHolidaTtravel")
    public JsonResult<Void> deleteHolidaTtravel(@RequestBody HolidaTtravelBo holidaTtravelBo) {
        if (holidaTtravelservice.deleteId(holidaTtravelBo)) {
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
    @PostMapping("/upadteIdHolidaTtravel")
    public JsonResult<Void> upadteIdHolidaTtravel(@RequestBody HolidaTtravelBo holidaTtravelBo) {
        if (holidaTtravelservice.upadteId(holidaTtravelBo)) {
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
