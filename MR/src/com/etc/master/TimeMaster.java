package com.etc.master;


import com.etc.mapper.TimeMapper;
import com.etc.reducer.TimeReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class TimeMaster {
    public static void main(String[] args) throws Exception{
        String inputPath = args[0];
        String outputPath = args[1];
        //初始化配置
        Configuration conf = new Configuration();
        //初始化job参数，指定job名称
        Job job = Job.getInstance(conf,"max");
        //设置运行job类
        job.setJarByClass(TimeMaster.class);
        //设置Mapper类
        job.setMapperClass(TimeMapper.class);
        //设置Reducer类
        job.setReducerClass(TimeReducer.class);
        //设置Map的输出数据类型
        job.setMapOutputValueClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        //设置Reducer的输出数据类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        //设置输入路径
        FileInputFormat.setInputPaths(job, new Path("hdfs://etc01:8020" + inputPath));
        FileOutputFormat.setOutputPath(job, new Path("hdfs://etc01:8020" + outputPath));
        boolean result = job.waitForCompletion(true);
        if (result){
            System.out.println("success!");
        }
    }
}
