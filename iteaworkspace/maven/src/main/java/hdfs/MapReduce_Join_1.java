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

public class MapReduce_Join_1 {
    public static class MyMapper extends Mapper<LongWritable, Text, Text, Text> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            // 获取文件路径
            FileSplit fileSplit = (FileSplit) context.getInputSplit();

            String s = fileSplit.toString();

            String s1 = value.toString();
            if (s.contains("dianxin_data")) {
                String[] split = s1.split("\t");
                if (split.length == 8 && split[2] != null) {
                    context.write(new Text(split[2]), new Text("dianxin" + split[0] + "," + split[4] + "," + split[7]));
                }
            }
            if (s.contains("city_id")) {
                String[] split = s1.split(",");
                if (split.length == 2) {
                    context.write(new Text(split[0]), new Text("city_id" + split[1]));
                }
            }
        }
    }

    public static class MyReduce extends Reducer<Text, Text, Text, Text> {
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            Vector<String> vectorA = new Vector<String>();
            Vector<String> vectorB = new Vector<String>();

            for (Text value : values) {
                String s = value.toString();

                if (s.startsWith("dianxin")) {
                    vectorA.add(s.substring(7));
                }
                if (s.startsWith("city_id")) {
                    vectorB.add(s.substring(7));
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
        // 配置环境
        Configuration configuration = new Configuration();

//        configuration.set("mapred.textoutputformat.separator", ",");

        // 生成任务
        Job job = Job.getInstance(configuration, MapReduce_Join_1.class.getSimpleName());
        // 指定jar包
        job.setJarByClass(MapReduce_Join_1.class);
        // 指定输入路径
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileInputFormat.addInputPath(job, new Path(args[1]));

        /**
         * 多个mapper方式:   multiple---多重  input---输入
         *      MultipleInputs.addInputPath(job, new Path(cityOdInput), CombineTextInputFormat.class, CityOdDataMapper.class);
         */

        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setReducerClass(MyReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.waitForCompletion(true);
    }
}
