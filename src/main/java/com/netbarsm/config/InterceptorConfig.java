package com.netbarsm.config;

import com.netbarsm.domain.BasUser;
import com.netbarsm.utils.SessionManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private SessionManage sessionManage;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        UserInterceptor userInterceptor = new UserInterceptor();
        InterceptorRegistration registration=registry.addInterceptor(userInterceptor);
        registration.addPathPatterns("/**");
        registration.excludePathPatterns("/","/basUser/register",  //跳转index界面的请求
                "/basUser/login",                               //登录请求
                "/findPassword",                        //找回密码请求
                "/test",                                //测试
                "/**/*.css",                            //静态文件
                "/**/*.jpg",
                "/**/*.js",
                "/**/*.ttf",
                "/**/*.woff",
                "/**/*.woff2",
                "/**/*.ico",
                "/**/*.map"
        );
    }


    private class UserInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            System.out.println("preHandle start: "+request.getRequestURI());
            BasUser basUser = sessionManage.getBasUser();
            if(basUser!=null){
                System.out.println("Interceptor: --"+request.getRequestURI()+"--true");
                return true;
            }
            System.out.println("Interceptor: --"+request.getRequestURI()+"--false");
            response.sendRedirect("/");
            return true;
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        }
    }
}
