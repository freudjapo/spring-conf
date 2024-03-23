package com.example.springconf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringConfApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringConfApplication.class, args);
    }

}

@RestController
@RefreshScope
@RequestMapping("project")
class ProjectController {

    @Value("${project.name}")
    private String projectName;

//    public ProjectController(@Value("${project.name}")String projectName){
//        this.projectName = projectName;
//    }

    @GetMapping("get")
    public ResponseEntity<String> get() {
        System.out.println("hello it wonderfu");
        return ResponseEntity.ok(this + "|" +this.projectName);
    }
}
