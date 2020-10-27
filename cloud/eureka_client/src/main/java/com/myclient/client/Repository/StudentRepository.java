package com.myclient.client.Repository;

import com.myclient.client.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;


public interface StudentRepository {
    public Collection<Student> findAll();

    public Student findById(Long id);

    public void saveOrUpdate(Student student);

    public void deleteStudent(Long id);

}
