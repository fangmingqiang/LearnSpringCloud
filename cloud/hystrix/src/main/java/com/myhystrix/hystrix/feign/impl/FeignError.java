package com.myhystrix.hystrix.feign.impl;

import com.myhystrix.hystrix.entity.Student;
import com.myhystrix.hystrix.feign.FeignProviderClient;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class FeignError implements FeignProviderClient {
    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务器错误!";
    }
}
