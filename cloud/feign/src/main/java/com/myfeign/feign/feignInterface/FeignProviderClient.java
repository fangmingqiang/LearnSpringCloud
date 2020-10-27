package com.myfeign.feign.feignInterface;

import com.myfeign.feign.entity.Student;
import com.myfeign.feign.feignInterface.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

//fallback 做降级处理,容错机制
@FeignClient(value = "provider",fallback = FeignError.class)
public interface FeignProviderClient {

    @GetMapping("student/all")
    public Collection<Student> findAll();

    @GetMapping("student/index")
    public String index();

}
