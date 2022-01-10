package com.zestfulYoghurt.zy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyStudyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doGet(req, resp);

        System.out.println("hello world");

        System.out.println(req);

        System.out.println(resp);

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("hello");

        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doPost(req, resp);

        System.out.println("MyStudyServlet 接受post方法");

    }

    @Override
    public void destroy() {

        super.destroy();

        System.out.println("MyStudyServlet 被销毁");

    }

    @Override
    public void init() throws ServletException {

        super.init();

        System.out.println("MyStudyServlet 被创建");

    }

}

