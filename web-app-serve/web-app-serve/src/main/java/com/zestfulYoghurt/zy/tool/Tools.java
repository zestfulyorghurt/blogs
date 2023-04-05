package com.zestfulYoghurt.zy.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;
import java.util.Random;

public class Tools {

    //生成随机数
    public static Integer createRandomInt(int baseNumber,int addNumber)
    {
        Random random = new Random();
        int RandomInt = baseNumber + random.nextInt(addNumber);
        return RandomInt;
    }

    public static String createSalt()
    {
        Random random = new Random();
        String randomCharacter =
                "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm123456789!@#$%^&*()_-+";
        StringBuilder salt = new StringBuilder();
        for(int i=0;i<6;i++)
        {
            int index = random.nextInt(randomCharacter.length());
            salt.append(randomCharacter.charAt(index));
        }
        return salt.toString();
    }


    public static class encryption
    {
        public static final int count = 1000;
        public static String passwordEncryption(String password, String salt)
        {
            return new Md5Hash(password, salt, count).toString();
        }
    }


    public static void connect(String host, String post, String username, String password)
    {
        DirContext ctx = null;
        Hashtable<String, String> HashEnv = new Hashtable<String, String>();
        HashEnv.put(Context.SECURITY_AUTHENTICATION, "simple"); // LDAP访问安全级别(none,simple,strong)
        HashEnv.put(Context.SECURITY_PRINCIPAL, "administrator@ac"); //AD的用户名 username+"@domain"
        HashEnv.put(Context.SECURITY_CREDENTIALS, password); //AD的密码
        HashEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory"); // LDAP工厂类
        HashEnv.put("com.sun.jndi.ldap.connect.timeout", "3000");//连接超时设置为3秒
        HashEnv.put(Context.PROVIDER_URL, "ldap://" + host + ":" + post);// 默认端口389
        try
        {
            ctx = new InitialDirContext(HashEnv);// 初始化上下文
            System.out.println("身份验证成功!");
        } catch (AuthenticationException e)
        {
            System.out.println("身份验证失败!");
            e.printStackTrace();
        } catch (javax.naming.CommunicationException e)
        {
            System.out.println("AD域连接失败!");
            e.printStackTrace();
        } catch (Exception e)
        {
            System.out.println("身份验证未知异常!");
            e.printStackTrace();
        } finally
        {
            if (null != ctx)
            {
                try {
                    ctx.close();
                    ctx = null;
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
