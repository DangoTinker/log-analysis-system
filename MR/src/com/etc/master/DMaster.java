package com.etc.master;

import com.etc.mapper.DMapper;
import com.etc.reducer.DReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class DMaster {
    public static void main(String[] args) throws Exception {
        Configuration configuration=new Configuration();
        String input=args[0];
        String output=args[1];
        System.out.println(input+" "+output);

        Job job=Job.getInstance();
        job.setJarByClass(DMaster.class);
        job.setMapperClass(DMapper.class);
        job.setReducerClass(DReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(job,new Path("hdfs://etc01:8020"+input));
        FileOutputFormat.setOutputPath(job,new Path("hdfs://etc01:8020"+output));
        boolean res=job.waitForCompletion(true);
        System.out.println(res);
    }
}
