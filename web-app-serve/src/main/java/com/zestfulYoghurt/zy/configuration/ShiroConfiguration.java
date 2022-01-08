package com.zestfulYoghurt.zy.configuration;


import com.zestfulYoghurt.zy.shiro.LoginRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;

/**
 * ClassName shiroConfiguration
 * Description TODO shiro框架配置
 * Author ZestfulYoghurt
 * Date 2021/06/02 2021.6.2
 * Version 1.0
 **/
@Configuration
    public class ShiroConfiguration implements WebMvcConfigurer {


        //解决跨域问题
        @Override
        public void addCorsMappings(CorsRegistry registry) {

            registry.addMapping("/**")//添加访问路径
                    .allowedOrigins("*")//允许的域，配置为所有
                    .allowedMethods("GET","HEAD","POST","DELETE","OPTIONS","PUT")//请求方式，配置为所有
                    .allowCredentials(true)//是否允许，设置为是
                    .maxAge(3600) //设置验证的最大时间
                    .allowedHeaders("*"); //设置响应头为全部

        }

    @Bean("defaultAdvisorAutoProxyCreator")
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {

        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();

        defaultAAP.setProxyTargetClass(true);

        return defaultAAP;

    }

    @Bean("myShiroRealm")
    public LoginRealm myShiroRealm(){

        LoginRealm loginRealm = new LoginRealm();

        return loginRealm;

    }


    @Bean("securityManager")
    public SecurityManager securityManager(){

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        securityManager.setRealm(myShiroRealm());

        return securityManager;

    }

    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        HashMap<String, String> map = new HashMap<>();

        //登出
        map.put("/logout","logout");

        //设置放行的url
        //设置注册url放行
        map.put("/register","anon");

        map.put("/test","anon");

        map.put("/error","anon");

        map.put("/loginCheckOut","anon");

        //对所有用户进行验证
        map.put("/**","authc");

        //登录
        shiroFilterFactoryBean.setLoginUrl("/loginCheckOut");

        //首页
        shiroFilterFactoryBean.setSuccessUrl("/index");

        //错误信息，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;

    }

    @Bean("authorizationAttributeSourceAdvisor")
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {

        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();

        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);

        return authorizationAttributeSourceAdvisor;

    }

}
