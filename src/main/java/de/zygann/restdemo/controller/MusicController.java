package de.zygann.restdemo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;

@RestController
@CrossOrigin
public class MusicController {
    @GetMapping
    public String getMusic() {
        return "Hello World";
    }

    @GetMapping(path = "/music", 
                produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getJson() {
        Resource resource = new ClassPathResource("/static/json/music.json");
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(resource.getInputStream(), Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}