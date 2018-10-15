package com.yuan.boot.controller;

import com.yuan.boot.utils.LoggerUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试controller
 */
@RestController
@RequestMapping("/hello")
@Api("测试类") //该注解表示对该类的说明
public class HelloController {

//    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @ApiOperation(value = "跳转到index页面",notes = "跳转到index页面") //使用该注解表示在使用swagger生成api文档时对该方法的说明
    @ApiImplicitParam(value = "用户的用户名",name = "name" ,required = true,dataType ="String") //使用该注解表示对该方法上的参数的说明
    @GetMapping("/index/{name}")
    public String hello(@PathVariable(name = "name") String name, Model model){
//        logger.trace("成功处理hello请求.........................");
        System.out.println("成功处理hello请求.........................");
        LoggerUtil.getLogger(this.getClass()).trace("成功处理hello请求.........................");
        model.addAttribute("mesage","欢迎用户"+name+"!!!");
         return "index";
    }


}
