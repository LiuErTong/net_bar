package com.netbarsm.service.impl;

import com.netbarsm.domain.BasUser;
import com.netbarsm.repository.BasUserRepository;
import com.netbarsm.service.BasUserService;
import com.netbarsm.utils.SessionManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

@Service
public class BasUserServiceImpl implements BasUserService {

    @Autowired
    private BasUserRepository basUserRepository;
    @Autowired
    private SessionManage sessionManage;


    @Override
    public boolean loginUser(HttpServletResponse response, String account, String password) {
        if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
            return false;
        }
        BasUser basUser = basUserRepository.selectByPrimaryKey(account);
        if(basUser != null && password.equals(basUser.getPassword())){
            sessionManage.addCookie(response,basUser);
            return true;
        }
        return false;
    }

    @Override
    public boolean registerUser(BasUser user) {
        if(user == null){
            return false;
        }
        String userId = user.getUserId();
        String password = user.getPassword();
        if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(password) || userId.length() != 18){
            return false;
        }
        try {
            basUserRepository.insert(user);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


}
