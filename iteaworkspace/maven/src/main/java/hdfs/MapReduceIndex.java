package hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MapReduceIndex {
    public static class MyMapper extends Mapper<LongWritable,Text,LongWritable,Text>{
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

            context.write(key,value);
        }
    }

    public static class MyReducer extends Reducer<LongWritable,Text,LongWritable,Text>{
        @Override
        protected void reduce(LongWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

            for (Text value : values) {
                context.write(key,value);
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // 设置配置文件
        Configuration configuration = new Configuration();
        // 生成任务
        Job job = Job.getInstance(configuration, MapReduceIndex.class.getSimpleName());
        // 指定jar包
        job.setJarByClass(MapReduceIndex.class);
        // 指定输入路径
        FileInputFormat.addInputPath(job,new Path(args[0]));

        // 指定map的类，指定key、value的数据类型
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(Text.class);

        // 指定reduce的类，指定key、value的数据类型
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(LongWritable.class);
        job.setOutputValueClass(Text.class);

        // 指定输出路径
        FileOutputFormat.setOutputPath(job,new Path(args[1]));
        // 任务完成
        job.waitForCompletion(true);
    }
}
