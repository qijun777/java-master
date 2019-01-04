package mapreduce;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.Arrays;

/**
 * 枚举
 * 不能通过new创建对象
 * 他的对象实在定义的时候创建
 */
enum Count {
    my;
}

/**
 * PageRank
 */

class PageRankMapper extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] split = value.toString().split("\t");
        //页面编号
        String page = split[0];
        //当前页面的pr值
        Double pr = Double.parseDouble(split[1]);
        //出链列表
        String[] outPageList = Arrays.copyOfRange(split, 2, split.length);
        //StringUtils.join  用一个分割符将数组拼接
        String pageValue = "#" + pr.toString() + "\t" + StringUtils.join(outPageList, "\t");
        context.write(new Text(page), new Text(pageValue));

        //计算分配给每一个页面的pr值
        Double v = pr / outPageList.length;
        for (String s : outPageList) {
            Text outKey = new Text(s);
            Text outValue = new Text("*" + v.toString());
            context.write(outKey, outValue);
        }
    }

}

class PageRankReducer extends Reducer<Text, Text, Text, Text> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        String pageValue = null;
        String page = key.toString();
        Double sumPr = 0.0;
        for (Text value : values) {
            String s = value.toString();
            if (s.startsWith("#")) {
                pageValue = s.substring(1);
            } else if (s.startsWith("*")) {
                sumPr = sumPr + Double.parseDouble(s.substring(1));
            }
        }

        //增加阻尼系数，当前的计算得分pr值
        Double currPr = (0.15 / 4) + (0.85 * sumPr);
        String[] split = pageValue.split("\t");
        //上一次pr值
        Double lastPr = Double.parseDouble(split[0]);

        double v = Math.abs(currPr - lastPr);
        //防止double丢失数据
        long v1 = (long) (v * 1000);

        //获取累加器
        Counter counter = context.getCounter(Count.my);
        //统计所有页面差值的和
        counter.increment(v1);
        String[] outPageList = Arrays.copyOfRange(split, 1, split.length);
        String outValue = currPr.toString() + "\t" + StringUtils.join(outPageList, "\t");
        context.write(key, new Text(outValue));

    }
}


public class RunJob {

    public static void main(String[] args) throws Exception {

        int count = 0;
        Double b = 0.01;

        while (true) {
            count++;

            Configuration config = new Configuration();
            FileSystem fs = FileSystem.get(config);
            Job job = Job.getInstance(config);
            job.setJarByClass(mapreduce.RunJob.class);
            job.setJobName("app");
            job.setMapperClass(PageRankMapper.class);
            job.setReducerClass(PageRankReducer.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(Text.class);
            job.setInputFormatClass(TextInputFormat.class);

            Path inputPath = new Path("E:\\bigdata\\mapreduce\\data\\pagerank.txt");

            if (count > 1) {
                inputPath = new Path("E:\\bigdata\\mapreduce\\data\\out\\pr" + (count - 1));
            }

            FileInputFormat.addInputPath(job, inputPath);
            Path outpath = new Path("E:\\bigdata\\mapreduce\\data\\out\\pr" + count);
            if (fs.exists(outpath)) {
                fs.delete(outpath, true);
            }
            FileOutputFormat.setOutputPath(job, outpath);
            boolean f = job.waitForCompletion(true);


            /**
             * 累加器
             * 相当于一个全局变量
             * 只能在map和reduce里面累加
             * 任务结束后在主函数里面读取
             *
             */
            //收敛条件
            //上一次pr值和当前计算的pr值的差值的平均值小于阈值
            //获取累加器的面的值
            Counter counter = job.getCounters().findCounter(Count.my);

            Double l = counter.getValue() / 4000.0;

            //如果差值的的平均值小于设定的阈值则收敛
            if (l < b) {
                break;
            }
        }
    }
}
