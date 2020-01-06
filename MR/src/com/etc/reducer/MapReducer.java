package com.etc.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MapReducer extends Reducer<Text, IntWritable,Text,IntWritable>{
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context){

        int sum=0;
        for (IntWritable value:values){
            sum += 1;
        }
        try {
            context.write( key,new IntWritable(sum));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
