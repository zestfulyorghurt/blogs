package com.zestfulYoghurt.zy.springRealize;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ClassName springBeanContext
 * Description TODO 查看spring创建的bean实例
 * Author ZestfulYoghurt
 * Date 2021/06/04 2021.6.4
 * Version 1.0
 **/
@Component
public class SpringBeanContext implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for(String bean:beanDefinitionNames){

            System.out.println(bean);

        }

    }

}
