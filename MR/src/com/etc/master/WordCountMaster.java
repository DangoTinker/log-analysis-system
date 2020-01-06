package com.etc.master;

import com.etc.mapper.WordCountMapper;
import com.etc.reducer.WordCountReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCountMaster {

    public static void main(String[] args) throws Exception{
        String input=args[0];
        String output=args[1];
        System.out.println(input+" "+output);
        Configuration configuration=new Configuration();
        Job job=Job.getInstance();
        job.setJarByClass(WordCountMaster.class);
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.setInputPaths(job,new Path("hdfs://etc01:8020"+input));
        FileOutputFormat.setOutputPath(job,new Path("hdfs://etc01:8020"+output));

        boolean res=job.waitForCompletion(true);
        if(res){
            System.out.println("success");
        }


    }

}
