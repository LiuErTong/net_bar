package com.netbarsm.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netbarsm.domain.BasUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author liutong
 * @version 1.0.0
 * @Description
 * @date 2022/3/2 19:07
 */
@Component
public class SessionManage {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private RedisUtils redisUtils;

    private static final String COOKIE_NAME_TOKEN = "token";

    //token过期时间 两小时
    private static final Integer TOKEN_EXPIRE = 3600 * 2;

    /**
     * @Description        用户信息生成token，存入redis
     * @param response
     * @param basUser
     * @return void
     * @author liutong
     * @date 2022/3/2 19:02
     */
    public void addCookie(HttpServletResponse response, BasUser basUser){
        String token = UUID.randomUUID().toString().replace("-", "");
        redisUtils.set(token, JSON.toJSONString(basUser));
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN,token);
        cookie.setMaxAge(TOKEN_EXPIRE);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * @Description     获取用户
     * @param
     * @return com.netbarsm.domain.BasUser
     * @author liutong
     * @date 2022/3/2 19:09
     */
    public BasUser getBasUser(){
        try {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if(COOKIE_NAME_TOKEN.equals(cookie.getName())){
                    String obj = redisUtils.get(cookie.getValue()).toString();
                    return JSONObject.parseObject(obj, BasUser.class);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
