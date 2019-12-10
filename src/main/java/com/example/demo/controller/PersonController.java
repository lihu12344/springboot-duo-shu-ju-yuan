package com.example.demo.controller;


import com.example.demo.dao.PersonMapper;
import com.example.demo.pojo.Person;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihu
 * @since 2019-12-10
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Resource
    private PersonMapper personMapper;

    @RequestMapping("/save")
    public String save(){
        for (int i=0;i<10;i++){
            Person person=new Person();
            person.setName("海贼王 "+i);
            person.setAge(i%4+12);

            personMapper.insert(person);
        }

        return "success";
    }
}