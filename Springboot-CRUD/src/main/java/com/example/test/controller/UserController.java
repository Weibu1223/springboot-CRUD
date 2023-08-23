package com.example.test.controller;

import com.example.test.Services.UserService;
import com.example.test.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userservice;
    @RequestMapping("/index")
    public  Object index(Model model){
        model.addAttribute("users" , userservice.getallUser());
        return  "index";
    }
    @GetMapping("/adduser")
    public String showadduser(Model model){
        model.addAttribute("user" , new User());
        return"add";
    }
//    @RequestMapping("/adduser")
//    public  Object addUser(Model model,
//            @RequestParam(value = "name")String name,
//            @RequestParam(value = "password")String password,
//            @RequestParam(value = "age")String age,
//            @RequestParam(value = "sex")String sex){
//        User user=new User();
//        user.setName(name);
//        user.setPassword(password);
//        user.setAge(age);
//        user.setSex(sex);
//        int addcode=userservice.addUser(user);
//        if(addcode==1){
//            model.addAttribute("code",200);
//            model.addAttribute("msg","添加数据成功");
//            return "add";
//        }else {
//            model.addAttribute("code",100);
//            model.addAttribute("msg","添加数据失败");
//            return "add";
//        }
//    }

    @PostMapping("/adduser")
    public String reshowaddUser(@ModelAttribute User user) {
        userservice.addUser(user);
        return "redirect:/user/index";
    }

//    @RequestMapping("/getalluser")
//    public  Object getAllUser(){
//        List<User> data=userservice.getallUser();
//        Map<String,Object>map=new HashMap<>();
//        if(data!=null&&data.size()>0){
//            map.put("code",200);
//            map.put("msg","获取数据成功");
//            map.put("data",data);
//        }else{
//            map.put("code",100);
//            map.put("msg","暂时没有数据");
//        }
//        return  map;
//    }
@GetMapping("/getusetbyid")
public String showFindUserForm(Model model) {
    model.addAttribute("user", null);
    return "Search";
}
//    @RequestMapping("/getusetbyid")
//    public  Object getUserById(Model model,@RequestParam (value = "id") Integer id){
//        User user=userservice.getuserbyId(id);
//        if(user!=null){
//            model.addAttribute("code",200);
//            model.addAttribute("msg","获取数据成功");
//            model.addAttribute("user",user);
//            return  "Searchresult";
//        }else{
//            model.addAttribute("code",100);
//            model.addAttribute("msg","暂时没有数据");
//            return  "Searchresult";
//        }
//    }
    @PostMapping("/getusetbyid")
    public String findUser(@RequestParam Integer userId, Model model) {
        User user = userservice.getuserbyId(userId);
        model.addAttribute("user", user);
        return "Searchresult";
    }
    @GetMapping("/updatepassword")
    public String showupdatepassword(Model model) {
        model.addAttribute("name", null);
        model.addAttribute("password", null);
        model.addAttribute("newpsw",null);
        return "Update";
    }
    @RequestMapping("/updatepassword")
    public  Object updatePassword(Model model,
                                  @RequestParam (value = "name") String name,
                                  @RequestParam (value = "password")String password,
                                  @RequestParam (value = "newpsw")String newpsw) {
//        if (TextUtils.isempty || TextUtils.Isempty(password) || TextUtils.Isempty(newpsw)) {
          if(name.isEmpty() || password.isEmpty() || newpsw.isEmpty()){
              model.addAttribute("msg", "帳號或密碼不能為空");
              model.addAttribute("code", 100);
            return "Update";
        } else {
            if (password.equals(newpsw)) {
                model.addAttribute("msg", "新密碼和舊密碼相同");
                model.addAttribute("code", 101);
                return "Update";
            } else {
                String infindpsw = userservice.upDatePassword(name, password, newpsw);
                if (infindpsw.equals("success")) {
                    model.addAttribute("msg", "修改密碼成功");
                    model.addAttribute("code", 200);
                    return "Update";
                } else if (infindpsw.equals("defeated")) {
                    model.addAttribute("msg", "舊密碼不對");
                    model.addAttribute("code", 102);
                    return "Update";
                } else if (infindpsw.equals("fail")) {
                    model.addAttribute("msg", "該用戶不存在");
                    model.addAttribute("code", 103);
                    return "Update";
                } else {
                    model.addAttribute("msg", "伺服器錯誤");
                    model.addAttribute("code", 104);
                    return "Update";
                }
            }
        }
    }
    @GetMapping("/deleteuser")
    public String showdeleteuserForm(Model model) {
        model.addAttribute("userId", null);
        return "Delete";
    }
//    @RequestMapping("/deleteuser")
//    public  Object deleteUser(Model model,@RequestParam (value = "id")Integer id){
//        User user=userservice.getuserbyId(id);
//        if(user!=null){
//            int deletecode=userservice.deleteUser(id);
//            if(deletecode==1){
//                model.addAttribute("code",200);
//                model.addAttribute("msg","删除数据成功");
//                return "Delete";
//            }else {
//                model.addAttribute("code",100);
//                model.addAttribute("msg","删除数据失败");
//                return "Delete";
//            }
//        }else{
//            model.addAttribute("code",101);
//            model.addAttribute("msg","不存在该条数据");
//            return "Delete";
//        }
//    }
    @PostMapping("/deleteuser")
    public String showdeleteuser(@RequestParam Integer userId, Model model) {
        int user = userservice.deleteUser(userId);
        model.addAttribute("user", user);
        return "redirect:/user/index";
    }
}
