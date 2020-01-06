package com.etc.master;

import com.etc.mapper.DMapper;
import com.etc.mapper.BrowserMapper;
import com.etc.reducer.DReducer;
import com.etc.reducer.BrowserReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class BrowserMaster {
    public static void main(String[] args) throws Exception {
        Configuration configuration=new Configuration();

        Job job=Job.getInstance();
        job.setJarByClass(BrowserMaster.class);
        job.setMapperClass(BrowserMapper.class);
        job.setReducerClass(BrowserReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        String input=args[0];
        String output=args[1];

        FileInputFormat.setInputPaths(job,new Path("hdfs://etc01:8020"+input));
        FileOutputFormat.setOutputPath(job,new Path("hdfs://etc01:8020"+output));
        boolean res=job.waitForCompletion(true);
        System.out.println(res);
    }
}
