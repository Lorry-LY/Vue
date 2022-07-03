package com.music.bigdata.config;

import com.music.bigdata.entity.User;
import com.music.bigdata.mapper.AccountMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 未登录拦截器
 */
@Component
public class CookieInterceptor implements HandlerInterceptor {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI()+"验证cookie开始");
        // 获得cookie
        Cookie[] cookies = request.getCookies();
        // 没有cookie信息，则重定向到登录界面
        if (null == cookies) {
            response.sendRedirect(request.getContextPath() + "/client/login");
            System.out.println("没有cookie，重定向到："+request.getContextPath() + "/client/login");
            return false;
        }
        // 定义cookie_username，用户的一些登录信息，例如：用户名，密码等
        String cookie_username = null;
        // 获取cookie里面的一些用户信息
        for (Cookie item : cookies) {
            if ("cookie_username".equals(item.getName())) {
                cookie_username = item.getValue();
                break;
            }
        }
        // 如果cookie里面没有包含用户的一些登录信息，则重定向到登录界面
        if (StringUtils.isEmpty(cookie_username)) {
            response.sendRedirect(request.getContextPath() + "/client/login");
            System.out.println("cookie里没有登录信息，重定向到："+request.getContextPath() + "/client/login");
            return false;
        }
        // 获取HttpSession对象
        HttpSession session = request.getSession();
        // 获取我们登录后存在session中的用户信息，如果为空，表示session已经过期
        Object obj = session.getAttribute("user");
        if (null == obj) {
            // 根据用户登录账号获取数据库中的用户信息
            User user = accountMapper.findUser(cookie_username).get(0);
            // 将用户保存到session中
            session.setAttribute("user", user);
        }
        // 已经登录
        return true;
    }
}
