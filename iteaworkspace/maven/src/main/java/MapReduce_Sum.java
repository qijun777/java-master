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

public class MapReduce_Sum {
    public static class MyMapper extends Mapper<LongWritable,Text,Text,LongWritable>{
        @Override
        protected void map(LongWritable key, Text value, Mapper<LongWritable,Text,Text,LongWritable>.Context context) throws IOException, InterruptedException {
            String s = value.toString();
            String[] split = s.split(",");

            String name = split[0];
            long money = Long.parseLong(split[2]);

            context.write(new Text(name), new LongWritable(money));
        }
    }

    public static class MyReduce extends Reducer<Text,LongWritable,Text,LongWritable>{
        @Override
        protected void reduce(Text key, Iterable<LongWritable> values, Reducer<Text,LongWritable,Text,LongWritable>.Context context) throws IOException, InterruptedException {
            long sum = 0L;
            for (LongWritable value : values) {
                sum += value.get();
            }
            context.write(key,new LongWritable(sum));
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
//        // 配置参数
//        Configuration configuration = new Configuration();
//        // 创建任务
//        Job job = Job.getInstance(configuration, MapReduce_Sum.class.getSimpleName());
//        // 指定jar文件
//        job.setJarByClass(MapReduce_Sum.class);
//        // 指定输入路径
//        FileOutputFormat.addInputPath(job,new Path(args[0]));
//
//        // 指定map的类
//        job.setMapperClass(MyMapper.class);
//        job.setMapOutputKeyClass(Text.class);
//        job.setMapOutputValueClass(LongWritable.class);
//
//        // 指定reduce的类
//        job.setReducerClass(MyReduce.class);
//        job.setOutputKeyClass(Text.class);
//        job.setOutputValueClass(LongWritable.class);
//
//        // 指定输出路径hdfs
//        FileOutputFormat.setOutputPath(job,new Path(args[2]));
//
//        // 提交任务，如果是true，则返回任务执行的任务信息等
//        job.waitForCompletion(true);


//        // 设置配置参数
//        Configuration configuration = new Configuration();
//        // 创建任务
//        Job job = Job.getInstance(configuration, MapReduce_Sum.class.getSimpleName());
//        // 指定jar文件
//        job.setJarByClass(MapReduce_Sum.class);
//        // 指定输入路径
//        FileInputFormat.addInputPath(job,new Path(args[0]));
//
//        // map
//        job.setMapperClass(MyMapper.class);
//        job.setMapOutputKeyClass(Text.class);
//        job.setMapOutputValueClass(LongWritable.class);
//
//        // Reduce
//        job.setReducerClass(MyReduce.class);
//        job.setOutputKeyClass(Text.class);
//        job.setOutputValueClass(LongWritable.class);
//
//        // 指定输出路径
//        FileOutputFormat.setOutputPath(job,new Path(args[1]));
//
//        // 提交任务，如果是true,则返回执行的任务信息等
//        job.waitForCompletion(true);



//        // 设置配置文件
//        Configuration configuration = new Configuration();
//        // 创建任务
//        Job job = Job.getInstance(configuration, MapReduce_Sum.class.getSimpleName());
//        // 指定jar文件
//        job.setJarByClass(MapReduce_Sum.class);
//        // 指定输入路径
//        FileInputFormat.addInputPath(job,new Path(args[0]));
//
//        // 指定Map的类
//        job.setMapperClass(MyMapper.class);
//        job.setMapOutputKeyClass(Text.class);
//        job.setMapOutputValueClass(LongWritable.class);
//
//        // 指定Reduce的类
//        job.setReducerClass(MyReduce.class);
//        job.setOutputKeyClass(Text.class);
//        job.setOutputValueClass(LongWritable.class);
//
//        // 指定输出路径hdfs
//        FileOutputFormat.setOutputPath(job,new Path(args[1]));
//
//        // 提交任务
//        job.waitForCompletion(true);


        // 设置配置文件
        Configuration configuration = new Configuration();
        // 创建任务
        Job job = Job.getInstance(configuration, MapReduce_Sum.class.getSimpleName());
        // 选择jar文件
        job.setJarByClass(MapReduce_Sum.class);
        // 指定输入路径
        FileInputFormat.addInputPath(job,new Path(args[0]));

        // 指定map的类
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        // 指定reduce的类
        job.setReducerClass(MyReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // 指定输出路径
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        // 提交任务
        job.waitForCompletion(true);

    }
}
