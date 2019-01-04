package hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.Vector;

public class MyReduce_Join {
    public static class MyMapper extends Mapper<LongWritable, Text, Text, Text> {
        @Override
        protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context) throws IOException, InterruptedException {
            // 获取切片信息
            FileSplit fileSplit = (FileSplit) context.getInputSplit();

            // 获取路径
            String s = fileSplit.getPath().toString();

            // 判断
            if (s.contains("dianxin_data")) {
                String s1 = value.toString();
                String[] split = s1.split("\t");
                if (split.length == 8 && split[2] != null) {
                    String valueA = "tl_hefei" + split[4] + "," + split[7];
                    // 将城市id作为key
                    context.write(new Text(split[2]), new Text(valueA));
                }
            }

            if (s.contains("city_id")) {
                String s1 = value.toString();
                String[] split = s1.split(",");
                if (split.length == 2) {
                    String valueB = "city_id" + split[1];
                    // 将城市id作为key
                    context.write(new Text(split[0]), new Text(valueB));
                }
            }
        }
    }

    public static class MyReducer extends Reducer<Text, Text, Text, Text> {
        @Override                                              // 泛型
        protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context) throws IOException, InterruptedException {
            // 创建两个集合
            Vector<String> vectorA = new Vector<String>();
            Vector<String> vectorB = new Vector<String>();

            // 判断
            for (Text value : values) {
                String line = value.toString();

                if (line.startsWith("tl_hefei")) {
                    vectorA.add(line.substring(8));
                }
                if (line.startsWith("city_id")) {
                    vectorB.add(line.substring(7));
                }
            }

            for (String s : vectorA) {
                for (String s1 : vectorB) {
                    context.write(new Text(s + key.toString()), new Text(s1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // 设置配置参数
        Configuration configuration = new Configuration();
//        configuration.set("mapred.textoutputformat.separator",",");

        // 创建任务
        Job job = Job.getInstance(configuration, MyReduce_Join.class.getSimpleName());
        // 选择jar包
        job.setJarByClass(MyReduce_Join.class);
        // 指定输入路径
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileInputFormat.addInputPath(job, new Path(args[1]));

        // 指定mapper的类及输出类型
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        // 指定reduce的类及输出的数据类型
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        // 指定输出路径
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        // 完成任务
        job.waitForCompletion(true);
    }
}
