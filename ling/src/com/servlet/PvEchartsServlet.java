package com.servlet;


import com.alibaba.fastjson.JSON;
import com.dao.PvDaoImp;
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

@WebServlet(name = "PvEchartsServlet", urlPatterns = "/PvEchartsServlet")
public class PvEchartsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        List<KeyValue> list = new ArrayList();
//        PVDao pvDao= new PVDao();
//        try {
//            list = pvDao.ReadPV();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        for (PVAdmin pvadmin:list
//             ) {
//            System.out.println(pvadmin.getCount());
//        }
//        PVAdmin pvAdmin = new PVAdmin();
//        PVAdmin pvAdmin1 = new PVAdmin();
//        pvAdmin.setPV("asdas");
//        pvAdmin.setCount(500);
//        pvAdmin1.setPV("456aadsa");
//        pvAdmin1.setCount(700);
//        list.add(pvAdmin);
//        list.add(pvAdmin1);

        BaseService service=new BaseService();

        try {
            list=service.queryCounts(PvDaoImp.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String  PVListJson = JSON.toJSONString(list);
        OutputStream out = response.getOutputStream();
        out.write(PVListJson.getBytes("UTF-8"));
        out.flush();
    }
}
