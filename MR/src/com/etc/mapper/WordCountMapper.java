package com.etc.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper<LongWritable, Text,Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String data=value.toString();
        String[] temp=data.split(" ");

        for (int i = 0; i < temp.length; i++) {
            context.write(new Text(temp[i]),new IntWritable(1));
        }

    }
}
