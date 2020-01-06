package com.service;

import com.dao.BaseDao;
import com.entity.KeyValue;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BaseService {
    public List<KeyValue> queryCounts(Class clazz) throws Exception {


        BaseDao dao= (BaseDao) clazz.newInstance();

        ResultSet rs=dao.queryAll();

        List<KeyValue> list=new ArrayList<KeyValue>();
        while(rs.next()){
            list.add(new KeyValue(rs.getString("name"),rs.getInt("value")));
        }

        return list;
    }

}
