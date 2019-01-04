package day20.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
        Date date = format.parse("2018-08-05");
        System.out.println(date);

        // 将日期变成字符串
        String dates = format.format(date);
        System.out.println(dates);
    }
}
