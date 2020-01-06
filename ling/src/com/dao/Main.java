package com.dao;

import com.entity.KeyValue;
import com.service.BaseService;

import java.sql.ResultSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        SearchDaoImp dao=new SearchDaoImp();
        ResultSet rs=dao.queryAll();
        while(rs.next()){

            System.out.println(rs.getString("word")+" : "+rs.getInt("count"));
        }

        BaseService service=new BaseService();
        List<KeyValue> list=service.queryCounts(SearchDaoImp.class);
        for (KeyValue kv:
             list) {
            System.out.println(kv.getName());
        }


    }
}
