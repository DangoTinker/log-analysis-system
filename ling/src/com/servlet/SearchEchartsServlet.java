package com.servlet;

//import com.movie.service.SearchService;
import com.alibaba.fastjson.JSON;

import com.dao.SearchDaoImp;
import com.entity.KeyValue;
import com.service.BaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@WebServlet(name = "SearchEchartsServlet",urlPatterns = "/SearchEchartsServlet")
public class SearchEchartsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        BaseService searchService=new BaseService();
        List<KeyValue> list=null;
        try {
            list=searchService.queryCounts(SearchDaoImp.class);
        } catch (Exception e) {
            e.printStackTrace();
        }


        String json= JSON.toJSONString(list);
        OutputStream outputStream=response.getOutputStream();
        outputStream.write(json.getBytes("utf-8"));
        outputStream.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
