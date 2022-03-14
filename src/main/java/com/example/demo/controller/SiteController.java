package com.example.demo.controller;

import com.example.demo.Service.SiteService;
import com.example.demo.entities.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/")

@ResponseBody
public class SiteController {
    @Autowired
    SiteService siteService = new SiteService();
    @GetMapping
    public ResponseEntity<List<Site>> findAll() throws Exception {
        return siteService.getSites();
    }
    @GetMapping(value ="/getSite")
    public ResponseEntity<Site> findAll(@RequestParam("site") String site) {
        return siteService.getSite(site);
    }
    @PostMapping(value = "/add")
    public void salvar(@RequestParam ("site") String site){
        siteService.save(site);
    }

}
