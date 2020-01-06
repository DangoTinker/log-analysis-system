package com.etc.mapper;

import com.etc.util.AddressUtil;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapMapper extends Mapper<LongWritable, Text,Text, IntWritable> {
    @Override
    protected void map(LongWritable key,Text value,Context context){
        String data=value.toString();
        String[] temp = data.split(" ");


        try {
            String address = AddressUtil.getAddress(temp[0]);
            System.out.println(address);

            context.write(new Text(address),new IntWritable(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
