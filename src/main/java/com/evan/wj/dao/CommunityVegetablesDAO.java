package com.evan.wj.dao;
import com.evan.wj.pojo.CommunityVegetables;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CommunityVegetablesDAO extends JpaRepository<CommunityVegetables,Integer> {
    List<CommunityVegetables> findAllByCommunityVegetables(CommunityVegetables commmunityVegetables);


}
