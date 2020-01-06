package com.etc.master;

import com.etc.mapper.SourceMapper;
import com.etc.reducer.SourceReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class SourceMaster {
    public static void main(String[] args) throws Exception {
        Configuration configuration=new Configuration();
        String input=args[0];
        String output=args[1];
        Job job=Job.getInstance();
        job.setJarByClass(SourceMaster.class);
        job.setMapperClass(SourceMapper.class);
        job.setReducerClass(SourceReducer.class);
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
