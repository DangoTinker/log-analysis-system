package com.etc.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class DReducer extends Reducer<Text, IntWritable,Text,IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        int max=values.iterator().next().get();
        for (IntWritable value:
             values) {
            if(max<value.get()){
                max=value.get();
            }
        }
        context.write(key,new IntWritable(max));

    }
}
