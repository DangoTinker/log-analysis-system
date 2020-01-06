package com.etc.master;

import com.etc.mapper.DMapper;
import com.etc.mapper.SearchMapper;
import com.etc.reducer.DReducer;
import com.etc.reducer.SearchReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class SearchMaster {
    public static void main(String[] args) throws Exception {
        Configuration configuration=new Configuration();

        Job job=Job.getInstance();
        job.setJarByClass(SearchMaster.class);
        job.setMapperClass(SearchMapper.class);
        job.setReducerClass(SearchReducer.class);
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
