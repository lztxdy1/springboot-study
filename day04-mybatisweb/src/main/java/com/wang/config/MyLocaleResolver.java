package com.wang.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//可以在链接上携带区域信息
public class MyLocaleResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        String language = request.getParameter("l");

        //System.out.println("language = " + language);
        //如果没有地区信息就返回默认地区信息
        Locale locale = Locale.getDefault();
        //如果请求的地区信息不为空
        if (StringUtils.hasLength(language)) {
            //分割请求参数
            String[] languages = language.split("_");
            //国家、地区
            locale = new Locale(languages[0], languages[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
