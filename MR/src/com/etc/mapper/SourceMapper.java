package com.etc.mapper;



import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SourceMapper extends Mapper<LongWritable, Text,Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {



        String data=value.toString();

        if (data.contains(".ico")||data.contains(".css")||data.contains(".png")){
            return;
        }

        String source="";

        String[] temp=data.split(" ");
        for (int i = 0; i <temp.length; i++) {
            System.out.print(temp[i]+":");
        }

        source=temp[temp.length-2];
        System.out.println(temp.length);
        context.write(new Text(source),new IntWritable(1));


    }
}
