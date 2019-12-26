package com.rjh.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 开启Servlet原生的组件扫描
@SpringBootApplication
public class RepeatReadStreamDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepeatReadStreamDemoApplication.class, args);
    }

}
