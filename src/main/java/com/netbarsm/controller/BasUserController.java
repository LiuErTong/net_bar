package com.netbarsm.controller;

import com.netbarsm.domain.BasUser;
import com.netbarsm.service.BasUserService;
import com.netbarsm.utils.JsonOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
@RequestMapping("/basUser")
public class BasUserController {

    @Autowired
    private BasUserService basUserService;

    @RequestMapping("/login")
    public HashMap userLogin(HttpServletResponse response, @RequestParam("account")String account, @RequestParam("password")String password){
        try {
            if(basUserService.loginUser(response,account, password)){
                return new JsonOut<>().addMessage("1").build();
            }
            return new JsonOut<>().addMessage("0").build();
        } catch (Exception e){
            e.printStackTrace();
            return new JsonOut<>().addResult(500).addMessage("登录失败").build();
        }
    }

    @RequestMapping("/register")
    public HashMap userRegister(@RequestBody BasUser user){
        String message = basUserService.registerUser(user)?"1":"0";
        return new JsonOut<>().addMessage(message).build();
    }

}
