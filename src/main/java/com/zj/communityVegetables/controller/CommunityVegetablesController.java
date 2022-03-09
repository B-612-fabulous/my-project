package com.zj.communityVegetables.controller;

import com.zj.communityVegetables.model.CommunityVegetablesBo;
import com.zj.communityVegetables.sercice.ICommunityVegetablesService;
import com.zj.config.Result.Result;
import com.zj.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@CrossOrigin
public class CommunityVegetablesController {
    @Autowired
    private ICommunityVegetablesService communityVegetablesService = null;
    @PostMapping("/addCommunityVegetables")
    public Result addCommunityVegetables(@RequestBody CommunityVegetablesBo cb) {
        Result rt = null;
        try {
            rt = communityVegetablesService.addCommunityVegetables(cb);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }
    @PostMapping("/getCommunityVegetablesList")
    public Result getCommunityVegetablesList(@RequestBody CommunityVegetablesBo cb) {
        Result rt = null;
        try {
            rt = communityVegetablesService.getCommunityVegetablesList(cb);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }
    @PostMapping("/deleteCommunityVegetablesList")
    public JsonResult<Void> deleteId(@RequestBody CommunityVegetablesBo communityVegetablesBo) {
        if (communityVegetablesService.deleteId(communityVegetablesBo)) {
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
    @PostMapping("/updateCommunityVegetablesList")
    public JsonResult<Void> upadteId(@RequestBody CommunityVegetablesBo communityVegetablesBo) {
        if (communityVegetablesService.upadteId(communityVegetablesBo)) {
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
