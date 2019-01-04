package hdfs;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.StringReader;

public class Test {
    public static void main(String[] args) throws Exception {
        String str = "我虽浪迹天涯，却未迷失本心";
        StringReader sr = new StringReader(str);

        IKSegmenter ikSegmenter = new IKSegmenter(sr, true);
        Lexeme word = null;
        while ((word = ikSegmenter.next()) != null) {
            String w = word.getLexemeText();
            System.out.println(w);
        }
    }
}
