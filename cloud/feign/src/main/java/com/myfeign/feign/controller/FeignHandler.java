package com.myfeign.feign.controller;

import com.myfeign.feign.entity.Student;
import com.myfeign.feign.feignInterface.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("feign")
public class FeignHandler {
    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping("all")
    public Collection<Student> findAll(){
        return feignProviderClient.findAll();
    }

    @GetMapping("index")
    public String index(){
        return feignProviderClient.index();
    }
}
