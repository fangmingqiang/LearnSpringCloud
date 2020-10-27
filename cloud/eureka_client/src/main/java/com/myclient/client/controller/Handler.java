package com.myclient.client.controller;

import com.myclient.client.Repository.StudentRepository;
import com.myclient.client.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class Handler {

    @Value("${server.port}")
    private String port;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("all")
    public Collection<Student>  findAll(){
        return studentRepository.findAll();
    }

    @GetMapping("find/{id}")
    public Student findById(@PathVariable("id") Long id){
        return studentRepository.findById(id);
    }

    @PostMapping("update")
    public void saveOrUpdate(@RequestBody Student student){
        studentRepository.saveOrUpdate(student);
    }

    @GetMapping("delete/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentRepository.deleteStudent(id);
    }

    @GetMapping("index")
    public String index(){
        return "当前服务端口是:"+port;
    }
}
