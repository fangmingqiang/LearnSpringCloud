package com.myhystrix.hystrix.feign;

import com.myhystrix.hystrix.entity.Student;
import com.myhystrix.hystrix.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Repository
@FeignClient(value = "provider",fallback = FeignError.class)
public interface FeignProviderClient {
    @GetMapping("student/all")
    public Collection<Student> findAll();

    @GetMapping("student/index")
    public String index();
}
