package com.yuan.boot.controller;

import com.yuan.boot.domain.User;
import com.yuan.boot.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 操作用户的controller
 * 注意：api要遵循RESETFULL风格
 */
@Api(tags = "操作user的控制类")
@Controller
@RequestMapping("/boot")
public class UserController {

    @Autowired
    private UserRepository repository;

    /**
     * 用户列表页面
     */
    @ApiOperation(value = "查询用户列表页面",notes = "查询用户列表页面")
    @ApiImplicitParam(name = "model",value = "用于把用户列表信息传到页面，无需传入",dataType = "Model")
    @GetMapping("/users")
    public ModelAndView userList(Model model)throws Exception{
        //查询所有的用户列表
        List<User> users = repository.findAll();
        model.addAttribute("users",users);
        //转发到用户列表显示页面
        return new ModelAndView("user/list");
    }

    /**
     * 转发到添加用户页面
     */
    @ApiOperation(value = "转发到添加新用户页面" ,notes = "转发到添加新用户页面")
    @GetMapping("/user")
    public ModelAndView toAddUserPage()throws Exception{
        return new ModelAndView("user/addUser");
    }

    /**
     * 保存添加的用户信息
     */
    @ApiOperation(value = "保存用户的信息",notes = "保存用户的信息")
    @ApiImplicitParam(name = "user",value = "封装用户信息的实体对象",dataType = "User")
    @PostMapping("/user")
    public String saveUser(User user)throws Exception{
        //保存用户的信息
        repository.saveOrUpdate(user);
        //重定向到用户列表页面 转发：forwork
        return "redirect:/boot/users";
    }

    /**
     * 根据用户的id删除指定的用户信息
     */
    @ApiOperation(value="根据用户的id删除用户",notes = "根据用户的id删除用户")
    @ApiImplicitParam(name = "id" ,value = "用户的id",required = true,dataType = "Integer")
    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable(name = "id")Integer id)throws Exception{
        //根据id删除用户的信息
        repository.deleteById(id);
        //重定向到用户列表页面
        return "redirect:/boot/users";
    }

    /**
     * 转发用户信息详情页面
     */
    @ApiOperation(value = "显示用户信息详情",notes = "显示用户信息详情")
    @ApiImplicitParam(name = "id",value = "要显示的用户信息的id",required = true,dataType = "Integer")
    @GetMapping("/user/{id}")
    public ModelAndView toUserView(@PathVariable(name = "id")Integer id,Model model)throws Exception{
        //根据用户的id查询用户的信息
        User user = repository.findBuId(id);
        model.addAttribute("user",user);


        return new ModelAndView("user/view");
    }

    /**
     * 转发到用户修改页面
     */
    @ApiOperation(value = "修改指定id的用户信息",notes = "修改指定id的用户信息")
    @ApiImplicitParam(name = "id",value = "要修改的用户的id",required = true,dataType = "Integer")
    @PutMapping("/usre/{id}")
    public ModelAndView toUpdatePage(@PathVariable(name = "id")Integer id ,Model model)throws Exception{

//        /根据用户的id查询用户的信息
        User user = repository.findBuId(id);

        model.addAttribute("user",user);
        return new ModelAndView("user/addUser");
    }



}
