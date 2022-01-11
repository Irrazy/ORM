package com.lzy.controller;

import com.github.pagehelper.PageInfo;
import com.lzy.pojo.User;
import com.lzy.serviceImpl.UserServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tk-generator-lombok
 * @description: userController
 * @author: 作者
 * @create: 2021-12-23 14:17
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserServiceImpl userServiceImpl;

    //分页---只做后端测试，没有前端页面展示
    @RequestMapping("/page")
    public List<User> getUsersByPage(@RequestParam(value = "pageNum",defaultValue = "2")Integer pageNum, Model model){
        // 首页右侧分类
        PageInfo<User> typePageInfo = userServiceImpl.getUsersByPage(pageNum,3);
        model.addAttribute("pageinfo",typePageInfo);//将pageinfo储存到模型中并返回到web页面
        List<User> list1 =  typePageInfo.getList();
        return list1;
    }
    //分页---加上前端页面展示
    @RequestMapping("/page2")
    public String getUsersByPage2(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum, Model model){

        // 首页右侧分类
        PageInfo<User> typePageInfo = userServiceImpl.getUsersByPage(pageNum,2);
        model.addAttribute("pageinfo",typePageInfo);
        return "index"; //--转换成jsp

    }


    @RequestMapping("/selectAll")
    public List<User> selectAll(){
        List<User> list1=userServiceImpl.selectAll();
        list1.forEach(System.out::println);
        return list1;
    }

    @RequestMapping("/findId")
    public User findById(){
        User user=userServiceImpl.findById(25L);
        System.out.println(user);
        return  user;
    }

    @RequestMapping("/insert")
    public String insert(User user){
        //user.setId(null);
        user.setAccount("Lily");
        user.setPassword("678976");
        int a=userServiceImpl.insertSelective(user);
        //int a=userServiceImpl.insert(user);
        System.out.println(a); //成功的话a的值是1
        return  "sucessful";
    }

    @RequestMapping("/updateByPrimaryKey")
    public String updateByPrimaryKey(){
        User user1=userServiceImpl.findById(27L);
        user1.setAccount("Lily4");
        user1.setPassword("0000");
        int a = userServiceImpl.updateByPrimaryKey(user1);
        System.out.println(a);
        if(a==1){
            return  "sucessful";
        }else{
            return  "erro";
        }
    }

    @RequestMapping("/deleteById")
    public String deleteById(){
        int a = userServiceImpl.delete(32L);
        System.out.println(a);
        if(a==1){
            return  "sucessful";
        }else{
            return  "erro";
        }

    }





}
