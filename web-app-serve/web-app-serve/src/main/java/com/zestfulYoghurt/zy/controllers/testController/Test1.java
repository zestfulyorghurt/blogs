package com.zestfulYoghurt.zy.controllers.testController;

import com.zestfulYoghurt.zy.pojos.basePojo.ResultBean;
import com.zestfulYoghurt.zy.pojos.basePojo.User;
import com.zestfulYoghurt.zy.pojos.configurationBean.ConfigurationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 *获取配置文件中的值
 */
@Controller
//@PropertySource("classpath:application-test1.properties")
public class Test1 {

    @Autowired
    private JavaMailSender mailSender;

//    @Value("${server.port}")
//    private String serverPort;

    HttpSession session;

    @Autowired
    private ConfigurationTest configurationTest;

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/test")
    @ResponseBody
    public Object getServerPort(HttpServletRequest request, HttpServletResponse response){

        session = request.getSession();

        Object user = session.getAttribute("user");

        System.out.println(user);

        SimpleMailMessage message = new SimpleMailMessage();
        // 发件人
        message.setFrom("2510906118@qq.com");
        // 收件人
        message.setTo("2211285218@qq.com");
        // 邮件标题
        message.setSubject("Java发送邮件第二弹");
        // 邮件内容
        message.setText("你好，这是一条用于测试Spring Boot邮件发送功能的邮件！哈哈哈~~~");
        // 抄送人
        //message.setCc("xxx@qq.com");
        //mailSender.send(message);
        //return configurationTest.getName();
        Map<Object, Object> map = new HashMap<>();
        map.put("id","noLogin");
        return new ResultBean(null,null,map);
    }



    //jsp测试

    @GetMapping("/")
    public String indexTest(){

        System.out.println("jsp");

        return "/WEB-INF/index.jsp";
    }

}
