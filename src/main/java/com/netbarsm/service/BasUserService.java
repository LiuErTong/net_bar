package com.netbarsm.service;

import com.netbarsm.domain.BasUser;

import javax.servlet.http.HttpServletResponse;

public interface BasUserService {


    boolean loginUser(HttpServletResponse response, String account, String password);

    boolean registerUser(BasUser user);
}
