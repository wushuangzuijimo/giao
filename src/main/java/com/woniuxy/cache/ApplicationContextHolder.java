package com.woniuxy.cache;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.ObjectInputStream;

/**
 * @version 1.0
 * @auther wushuang
 * @date 2019/11/4 14:10
 */

@Component
public class ApplicationContextHolder implements ApplicationContextAware{
    private static ApplicationContext atx;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        atx = applicationContext;

    }
    //向外界提供一个方法
    public static <T> T getBean(Class<T> cls) {
        return atx.getBean(cls);
    }


    public static <T> T getBean(String name) {
        return (T)atx.getBean(name);
    }


}