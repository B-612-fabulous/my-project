package com.zj.communityVegetables.controller;

import com.zj.communityVegetables.model.CommunityVegetablesBo;
import com.zj.communityVegetables.sercice.ICommunityVegetablesService;
import com.zj.config.Result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class CommunityVegetablesController {
    @Autowired
    private ICommunityVegetablesService communityVegetablesService = null;
    @PostMapping("/addCommunityVegetables")
    public Result login(@RequestBody CommunityVegetablesBo cb) {
        Result rt = null;
        try {
            rt = communityVegetablesService.addCommunityVegetables(cb);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }
}
