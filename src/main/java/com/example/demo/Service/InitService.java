package com.example.demo.Service;

import com.example.demo.entities.Site;
import com.example.demo.repositories.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InitService {
    @Autowired
    SiteRepository siteRepository;
    public InitService() {
        try {
            Site site = new Site("google.com");
            Site site1 = new Site("facebook.com");
            Site site2 = new Site("instagram.com");
            Site site3 = new Site("pt.quora.com");
            Site site4 = new Site("outlook.live.com");
            siteRepository.save(site);
            siteRepository.save(site1);
            siteRepository.save(site2);
            siteRepository.save(site3);
            siteRepository.save(site4);
        }catch(Exception e){
          System.out.println(e);
        }
    }
}
