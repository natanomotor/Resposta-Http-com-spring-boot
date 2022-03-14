package com.example.demo.repositories;

import com.example.demo.entities.Site;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository extends JpaRepository<Site, Integer> {

}
