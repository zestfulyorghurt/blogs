package com.zestfulYoghurt.zy.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

/**
 * ClassName Tools
 * Description TODO 加密工具
 * Author ZestfulYoghurt
 * Date 2021/06/04 2021.6.4
 * Version 1.0
 **/
public class Tools {
    /**
     * @Author ZestfulYoghurt
     * @Description //TODO 用于加密的内部类
     * @Date 17:10 2021/06/04
     * @Param
     * @return
     **/
    public static class encryption {

        public static final int count = 2;

        public static String passwordEncryption(String password, String salt) {

            return new Md5Hash(password, salt, count).toString();

        }

    }


    /**
     * @return
     * @Author ZestfulYoghurt
     * @Description //TODO 用于验证用户的ad域
     * @Date 17:10 2021/11/04
     * @Param
     **/
    public static void connect(String host, String post, String username, String password) {

        DirContext ctx = null;

        Hashtable<String, String> HashEnv = new Hashtable<String, String>();

        HashEnv.put(Context.SECURITY_AUTHENTICATION, "simple"); // LDAP访问安全级别(none,simple,strong)

        HashEnv.put(Context.SECURITY_PRINCIPAL, "administrator@ac"); //AD的用户名 username+"@domain"

        HashEnv.put(Context.SECURITY_CREDENTIALS, password); //AD的密码

        HashEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory"); // LDAP工厂类

        HashEnv.put("com.sun.jndi.ldap.connect.timeout", "3000");//连接超时设置为3秒

        HashEnv.put(Context.PROVIDER_URL, "ldap://" + host + ":" + post);// 默认端口389

        try {

            ctx = new InitialDirContext(HashEnv);// 初始化上下文

            System.out.println("身份验证成功!");

        } catch (AuthenticationException e) {

            System.out.println("身份验证失败!");

            e.printStackTrace();

        } catch (javax.naming.CommunicationException e) {

            System.out.println("AD域连接失败!");

            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("身份验证未知异常!");

            e.printStackTrace();

        } finally {

            if (null != ctx) {

                try {

                    ctx.close();

                    ctx = null;

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        }

    }

}
