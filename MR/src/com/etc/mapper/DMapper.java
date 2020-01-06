package com.etc.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DMapper extends Mapper<LongWritable, Text,Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String data=value.toString();
        String year="";
        String de;

            year="";
            de="";
            for (int j = 0; j <=3 ; j++) {
                year+=data.charAt(j);
            }
            for (int j = 8; j <data.length() ; j++) {
                de+=data.charAt(j);
            }
            context.write(new Text(year),new IntWritable(Integer.valueOf(de)));


    }
}
