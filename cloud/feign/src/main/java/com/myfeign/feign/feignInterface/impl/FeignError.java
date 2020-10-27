package com.myfeign.feign.feignInterface.impl;

import com.myfeign.feign.entity.Student;
import com.myfeign.feign.feignInterface.FeignProviderClient;
import org.springframework.stereotype.Component;

import java.util.Collection;

//熔错处理 Component把FeignError注入Ioc容器中
@Component
public class FeignError implements FeignProviderClient {
    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务器维护中。。。";
    }
}
