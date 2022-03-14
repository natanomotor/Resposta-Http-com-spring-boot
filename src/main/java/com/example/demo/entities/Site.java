package com.example.demo.entities;

import com.example.demo.exceptions.SiteNotFoundException;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Site {

    @Id
    @NonNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String adress;
    @NonNull
    private boolean isOnline;

   public Site(String adress) throws Exception{
           try{
               if(siteValidate(adress) == true){
                   this.adress = adress;
                   this.isOnline = true;
               }
           }catch(UnknownHostException e){
               this.adress = adress;
               this.isOnline = false;
           }

    }
    private boolean siteValidate(String adress) throws Exception{
       if(!adress.contains("http://") || !adress.contains("https://")){
           adress = "http://"+adress;
       }
        try{
            URL u = new URL(adress);
            int codeResponse = 0;
            HttpURLConnection huc = (HttpURLConnection) u.openConnection();
            huc.setRequestMethod("GET");
            huc.connect();
            codeResponse = huc.getResponseCode();
            System.out.println(codeResponse);
            if(codeResponse >=400){
                return false;
            }else{
                return true;
            }
        }catch(Exception e){
            System.out.println(e);
            return false;
        }

    }

}
