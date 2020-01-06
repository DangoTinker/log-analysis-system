package com.servlet;

import com.alibaba.fastjson.JSON;

import com.entity.KeyValue;
import com.dao.BrowserDaoImp;
import com.service.BaseService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "BrowserEchartsServlet", urlPatterns = "/BrowserEchartsServlet")
public class BrowserEchartsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("BrowserEchartsServlet");
        List<KeyValue> list = new LinkedList<>();
        BaseService service=new BaseService();

        try {
            list=service.queryCounts(BrowserDaoImp.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String aJson = JSON.toJSONString(list);
        OutputStream outputStream=response.getOutputStream();
        outputStream.write(aJson.getBytes("utf-8"));
        outputStream.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //其实走的是doGetaaaaaaaaaaaaaaaaa!!!
        doPost(request,response);
    }
}
