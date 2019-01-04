package com.shujia.controlet;

import com.shujia.bean.StudentScore;
import com.shujia.service.StudentService;
import com.shujia.service.impl.StudentServiceImpl;
import com.shujia.util.DBUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class StudentController {

    private StudentService studentService = new StudentServiceImpl();

    /**
     * value = "/query"--访问路径
     * method = RequestMethod.GET--http的请求方式（get  post）
     */
    // 查询学生的分数（学号，姓名，班级，科目，分数）
    @RequestMapping(value = "/query", method = RequestMethod.GET)

    /**
     * 方法的返回值如果是集合或对象，spring会自动将其转换为json字符串
     */

    /**
     * http://localhost:8080/query?studentId=1500100001&name=张三
     * 在请求地址后面加参数  中间用？隔开
     * 参数名和方法参数名对应
     * 如果要传多个参数 用&隔开
     */
    public List<StudentScore> queryScore(String studentId){
        List<StudentScore> studentScores = studentService.queryScoreById(studentId);
        return studentScores;

//        ArrayList<StudentScore> scores = new ArrayList<>();
//        Connection connection = DBUtil.getConnection();
//
//        String sql = "select stu.sno,stu.sname,stu.class,cou.cno as course,sco.degree from student as stu join score as sco on stu.sno=sco.sno join course as cou on sco.cno=cou.cno where stu.sno = ?";
//
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,studentId);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()){
//                String string = resultSet.getString(1);
//                String string1 = resultSet.getString(2);
//                String string2 = resultSet.getString(3);
//                String string3 = resultSet.getString(4);
//                int anInt = resultSet.getInt(5);
//
//                StudentScore studentScore = new StudentScore(string, string1, string2, string3, anInt);
//                scores.add(studentScore);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBUtil.close(connection,preparedStatement);
//        }
//        return scores;
    }
}
