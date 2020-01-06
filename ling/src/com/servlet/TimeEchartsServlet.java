package com.servlet;

import com.alibaba.fastjson.JSON;
import com.dao.TimeDaoImp;
import com.entity.KeyValue;
import com.service.BaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TimeEchartsServlet", urlPatterns = "/TimeEchartsServlet")
public class TimeEchartsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        List<KeyValue> list = new ArrayList();
        BaseService service=new BaseService();
        try {
            list = service.queryCounts(TimeDaoImp.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String cateListJson = JSON.toJSONString(list);
        OutputStream out = response.getOutputStream();
        out.write(cateListJson.getBytes("UTF-8"));
        out.flush();
    }
}
