package com.etc.master;

import com.etc.mapper.MapMapper;
import com.etc.reducer.MapReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MapMaster {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        String inputPath=args[0];
        String outputPath=args[1];
        Configuration configuration=new Configuration();
        configuration.set("fs.defaultFS","hdfs://etc01:8020");
        FileSystem hdfs = FileSystem.get(configuration);
     //   System.out.println("旧文件还在");
    /*    if (hdfs.delete(new Path("hdfs://etc01:8020/" + outputPath))) {
            System.out.println("文件未能删除");
        } else {
            System.out.println("文件" + outputPath + "已删除");
        }
*/
        hdfs.close();

        Job job=Job.getInstance(configuration);
        job.setJarByClass(MapMaster.class);
        job.setMapperClass(MapMapper.class);
        job.setReducerClass(MapReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(job,new Path("hdfs://etc01:8020/"+inputPath));
        FileOutputFormat.setOutputPath(job,new Path("hdfs://etc01:8020/"+outputPath));
        boolean result=job.waitForCompletion(true);
        if(result){
            System.out.println("succeed");
        }
    }
}
