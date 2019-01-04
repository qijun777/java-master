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

public class MapReduce_Join {
    public static class MyMapper extends Mapper<LongWritable, Text, Text, Text> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            /**
             * 有两个文件夹
             */
            // 分清每个文件来自哪个文件夹  split---分离
            FileSplit fileSplit = (FileSplit) context.getInputSplit();

            String s = fileSplit.getPath().toString();

            if (s.contains("dianxin_data")) {
                String s1 = value.toString();
                String[] split = s1.split("\t");
                if (split.length == 8 && split[2] != null) {
                    String valueA = "dianxin" + split[0] + "," + split[4];
                    context.write(new Text(split[2]), new Text(valueA));
                }
            }
            if (s.contains("city_id")) {
                String s1 = value.toString();
                String[] split = s1.split(",");
                if (split.length == 2 && split[0] != null) {
                    String valueB = "city_id" + split[1];
                    context.write(new Text(split[0]), new Text(valueB));
                }
            }

        }
    }

    public static class MyReducer extends Reducer<Text, Text, Text, Text> {
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            // 两个集合
            Vector<String> vectorA = new Vector<String>();
            Vector<String> vectorB = new Vector<String>();

            for (Text value : values) {
                String s = value.toString();

                if (s.startsWith("dianxin")) {
                    vectorA.add(s.substring(7));
                }

                if (s.startsWith("city_id")) {
                    vectorB.add(s.substring(8));
                }
            }

            for (String s1 : vectorA) {
                for (String s2 : vectorB) {
                    context.write(new Text(s1 + key.toString()), new Text(s2));
                }
            }

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // 设置配置环境
        Configuration configuration = new Configuration();
        // 生成文件任务    instance---实例
        Job job = Job.getInstance(configuration, MapReduce_Join.class.getSimpleName());
        // 指定jar包
        job.setJarByClass(MapReduce_Join.class);
        // 指定输入路径
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileInputFormat.addInputPath(job, new Path(args[1]));

        // 指定map的类
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        // 指定reduce的类
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        // 指定输出路径
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        // 任务完成
        job.waitForCompletion(true);
    }
}
