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

public class MapReduceWC {
    // 第一部分 写map阶段
    // 指定map输入输出的指定key和value的序列化类型hdfs.MapReduceWC
    public static class MyMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
        // map函数处理每一行数据，一行数据是一个对象，调用一次map函数
        // context 这个参数是承上启下的意思，里面包括整个任务信息，可以执行数据写入写出
        protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context) throws IOException, InterruptedException {
            // 先将该行数据转换成字符型数据
            String s = value.toString();
            // 切割
            String[] split = s.split(",");

            for (String s1 : split) {
                // 组键k2,v2 单词统计 将value写死为1
                // 数据通过context传入磁盘
                context.write(new Text(s1), new LongWritable(1L));

            }
        }
    }

    // shuffle 进行合并、分区、分组、排序  相同k2的数据会被同一个reduce拉取
    // 第二部分 reduce阶段
    public static class MyReduce extends Reducer<Text, LongWritable, Text, LongWritable> {
        @Override
        protected void reduce(Text k2, Iterable<LongWritable> v2s, Reducer<Text, LongWritable, Text, LongWritable>.Context context) throws IOException, InterruptedException {
            // 将value加起来
            long count = 0L;
            for (LongWritable v2 : v2s) {
                count += v2.get();
            }
            // 将结果输出到hdfs上
            context.write(k2, new LongWritable(count));

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // 设置配置参数
        Configuration configuration = new Configuration();
        // 创建任务
        Job job = Job.getInstance(configuration, MapReduceWC.class.getSimpleName());

        // 指定jar文件
        job.setJarByClass(MapReduceWC.class);
        // 指定输入路径，数据在hdfs上的输入路径，指定第一个参数是hdfs上的输入路径

        FileInputFormat.addInputPath(job, new Path(args[0]));


        // 指定map类
        job.setMapperClass(MyMapper.class);
        // 指定Map输出的key和value的数据类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        // 指定reduce类及输出数据类型
        job.setReducerClass(MyReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // 指定输出路径hdfs
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        // 提交任务
        job.waitForCompletion(true);

    }

}
