package com.myclient.client.Repository;

import com.myclient.client.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
    private static Map<Long,Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put(1L,new Student(1L,"张三",21));
        studentMap.put(2L,new Student(2L,"李四",21));
        studentMap.put(3L,new Student(3L,"王五",21));
    }

    @Override
    public Collection<Student> findAll() {
        return studentMap.values();
    }

    @Override
    public Student findById(Long id) {
        return studentMap.get(id);
    }

    @Override
    public void saveOrUpdate(Student student) {
        studentMap.put(student.getId(),student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentMap.remove(id);
    }
}
