package com.zestfulYoghurt.zy.configuration;


import com.zestfulYoghurt.zy.handlerInterceptor.TokenVerification;
import com.zestfulYoghurt.zy.servlet.MyStudyServlet;
import com.zestfulYoghurt.zy.shiro.LoginRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Servlet;
import java.util.HashMap;

/**
 * ClassName shiroConfiguration
 * Description TODO shiro框架配置
 * Author ZestfulYoghurt
 * Date 2021/06/02 2021.6.2
 * Version 1.0
 **/
@Configuration
    public class ConfigurationSpringBoot implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {

        registry.addInterceptor(TokenVerification()).addPathPatterns("/**");

    }

    @Bean
    public TokenVerification TokenVerification(){

        return new TokenVerification();

    }


    //配置servlet
    @Bean
    public ServletRegistrationBean registrationBean(){

        ServletRegistrationBean<Servlet> servletServletRegistrationBean
                = new ServletRegistrationBean<>(new MyStudyServlet(),"/servlet");

        return servletServletRegistrationBean;

    }

    @Bean("defaultAdvisorAutoProxyCreator")
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {

        DefaultAdvisorAutoProxyCreator defaultAAP
                = new DefaultAdvisorAutoProxyCreator();

        defaultAAP.setProxyTargetClass(true);

        return defaultAAP;

    }


    /**
     * 凭证匹配器
     * 密码校验交给Shiro的SimpleAuthenticationInfo进行处理
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher =
                new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数;
        return hashedCredentialsMatcher;
    }

    @Bean("myShiroRealm")
    public LoginRealm myShiroRealm()
    {
        LoginRealm loginRealm = new LoginRealm();
        loginRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return loginRealm;

    }


    @Bean("securityManager")
    public SecurityManager securityManager(){

        DefaultWebSecurityManager securityManager
                = new DefaultWebSecurityManager();

        securityManager.setRealm(myShiroRealm());

        return securityManager;

    }

    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean
    shiroFilterFactoryBean(SecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean
                = new ShiroFilterFactoryBean();
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
        map.put("/servlet","anon");
        //对所有用户进行验证
        map.put("/**","authc");
        //登录
        shiroFilterFactoryBean.setLoginUrl("/loginCheckOut");
        //错误信息，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    @Bean("authorizationAttributeSourceAdvisor")
    public AuthorizationAttributeSourceAdvisor
    authorizationAttributeSourceAdvisor(SecurityManager securityManager) {

        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor
                = new AuthorizationAttributeSourceAdvisor();

        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
