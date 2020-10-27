package com.myrest.rest.controller;

import com.myrest.rest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("rest")
public class RestHandle {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("all")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://localhost:8080/student/all",Collection.class).getBody();
    }

    @GetMapping("find/{id}")
    public Student findById(@PathVariable("id") Long id){
        return restTemplate.getForObject("http://localhost:8080/student/find"+id,Student.class);
    }

    @PostMapping("save")
    public void saveStudent(Student student){
        restTemplate.postForObject("http://localhost:8080/student/update",student,null);
    }

    @PutMapping("update")
    public void UpdateStudentById(@RequestBody Student student){
        restTemplate.put("http://localhost:8080/student/update",student);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        restTemplate.delete("http://localhost:8080/student/delete/"+id);
    }

}
