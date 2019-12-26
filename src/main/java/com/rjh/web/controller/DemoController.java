package com.rjh.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 演示用的Controller
 * @author Null
 * @date 2019-12-26
 */
@RestController
public class DemoController {

    @PostMapping
    public Map<String,Object> echo(@RequestBody Map<String,Object> map){
        return map;
    }

}
