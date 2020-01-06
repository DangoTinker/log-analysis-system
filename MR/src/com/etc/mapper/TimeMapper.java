package com.etc.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.junit.Test;

import javax.naming.Context;
import java.io.IOException;

public class TimeMapper extends Mapper<LongWritable,Text,Text,IntWritable> {
    @Override
    protected void map(LongWritable Key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        System.out.println(line);
        String Date = line.substring(18,29);
        String time = line.substring(30,32);
        context.write(new Text(Date), new IntWritable(0));
        context.write(new Text(time), new IntWritable(1));
    }
}