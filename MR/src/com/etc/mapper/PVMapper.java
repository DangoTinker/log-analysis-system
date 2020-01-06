package com.etc.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.junit.Test;

import javax.naming.Context;
import java.io.IOException;

public class PVMapper extends Mapper<LongWritable,Text,Text,IntWritable> {
    @Override
    protected void map(LongWritable Key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        System.out.println(line);
        int a = line.indexOf("web/");
        int b = line.indexOf(".jsp");
        int c = line.indexOf(".html");
        String page;
        if(a >= 0) {
            if (b >= 0) {
                page = line.substring(a + 4, b + 4);
                System.out.println(page);
                context.write(new Text(page), new IntWritable(1));
            } else if (c >= 0) {
                page = line.substring(a + 4, c + 5);
                System.out.println(page);
                context.write(new Text(page), new IntWritable(1));
            }
        }
    }
}