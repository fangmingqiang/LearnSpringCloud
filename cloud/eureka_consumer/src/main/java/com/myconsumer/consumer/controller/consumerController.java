package com.myconsumer.consumer.controller;

import com.myconsumer.consumer.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("consumer")
public class consumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("all")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://localhost:8080/rest/all",Collection.class).getBody();
    }

    @GetMapping("/find/{id}")
    public Student findById(@PathVariable("id") Long id){
        return restTemplate.getForObject("http://localhost:8080/rest/find/"+id,Student.class);
    }

    @PostMapping("save")
    public void save(Student student){
        restTemplate.postForObject("http://localhost:8080/rest/save",student,null);
    }

    @PutMapping("update")
    public void update(Student student){
        restTemplate.put("http://localhost:8080/rest/update",student);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        restTemplate.delete("http://localhost:8080/rest/update/{id}",id);
    }

}
