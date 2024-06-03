package com.gradproject.moviesearcher;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import java.util.List;

@Controller

@RequestMapping("/")

public class MediaController {

    @Autowired
    private MediaService mediaService;
    @GetMapping
    public String home() {
        return "search";
    }
    @GetMapping("/search")
    public String search(String q, Model attributes) {
        
        attributes.addAttribute("q", q);
        long startTime = System.currentTimeMillis();
        List<Media> docs = mediaService.searchMedia(q);
        long endTime = System.currentTimeMillis();
        // İşlem süresini hesapla
        long elapsedTime = endTime - startTime;
        System.out.println("İşlem süresi: " + elapsedTime + " milisaniye");
        attributes.addAttribute("docs", docs);
       

        return "search";
    }


    
}