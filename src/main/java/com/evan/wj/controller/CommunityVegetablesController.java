package com.evan.wj.controller;
import com.evan.wj.pojo.CommunityVegetables;
import com.evan.wj.service.CommunityVegetablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class CommunityVegetablesController {
    @Autowired
    CommunityVegetablesService communityVegetablesService;
    @GetMapping("/api/communityVegetables")
    public List<CommunityVegetables> list() throws Exception {
        return communityVegetablesService.list();
    }
}
