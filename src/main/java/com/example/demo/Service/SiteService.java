package com.example.demo.Service;

import com.example.demo.entities.Site;
import com.example.demo.repositories.SiteRepository;
import org.hibernate.loader.plan.build.spi.ExpandingCollectionQuerySpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class SiteService {
    @Autowired
    SiteRepository siteRepository;
    public void save(String endereço){
        Site site;
        try{
            site = new Site(endereço);
            siteRepository.save(site);

        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResponseEntity<List<Site>> getSites() {
        return new ResponseEntity<List<Site>>(siteRepository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<Site> getSite(String endereco){
        List<Site> sites = siteRepository.findAll();
        for(int i = 0; i < sites.size(); i++){
            if(sites.get(i).getAdress().equalsIgnoreCase(endereco)){
                return new ResponseEntity<Site>(sites.get(i),HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
