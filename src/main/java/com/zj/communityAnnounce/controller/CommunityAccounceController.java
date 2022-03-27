package com.zj.communityAnnounce.controller;
import com.zj.communityAnnounce.model.CommunityAnnounceBo;
import com.zj.communityAnnounce.service.ICommunityAnnounceService;
import com.zj.config.Result.Result;
import com.zj.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class CommunityAccounceController {
    @Autowired
    private ICommunityAnnounceService iCommunityAnnounceService;


    @PostMapping("/getCommunityAnnounceList")
    public Result getCommunityAnnounceList(@RequestBody CommunityAnnounceBo ca) {
        Result rt = null;
        try {
            rt = iCommunityAnnounceService.getCommunityAnnounceList(ca);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }
    @PostMapping("/addCommunityAnnounce")
    public Result addICommunityAnnounce1 (@RequestBody CommunityAnnounceBo ca){
        Result rt = null;
        try {
            rt = iCommunityAnnounceService.addICommunityAnnounce1(ca);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }

    @PostMapping("/deleteCommunityAnnounce")
    public JsonResult<Void> deleteId(@RequestBody CommunityAnnounceBo ca) {
        if (iCommunityAnnounceService.deleteId(ca)) {
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
    @PostMapping("/updateCommunityAnnounce")
    public JsonResult<Void> upadteId(@RequestBody CommunityAnnounceBo ca) {
        if (iCommunityAnnounceService.upadteId(ca)) {
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
    @PostMapping("/searchCommunityAnnounce")
    public Result searchCommunityAnnounce(@RequestBody CommunityAnnounceBo ca) {
        Result rt = null;
        try {
            rt = iCommunityAnnounceService.selectByid(ca);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }
}
