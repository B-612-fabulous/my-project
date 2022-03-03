package com.evan.wj.service;
import com.evan.wj.dao.CommunityVegetablesDAO;
import com.evan.wj.pojo.CommunityVegetables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityVegetablesService {

    @Autowired
    CommunityVegetablesDAO communityVegetablesDAO;
    public List<CommunityVegetables> list(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return communityVegetablesDAO.findAll(sort);
    }
//    public void addOrUpdate(CommunityVegetables communityVegetables) {
//        communityVegetablesDAO.save(communityVegetables);
//    }
//    public void findAllByCommunityVegetables(CommunityVegetables communityVegetables) {
//        communityVegetablesDAO.save(communityVegetables);
//    }
//
//    public void deleteById(int id) {
//        communityVegetablesDAO.deleteById(id);
//    }
}
