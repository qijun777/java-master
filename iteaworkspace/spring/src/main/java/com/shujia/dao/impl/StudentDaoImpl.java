package com.shujia.dao.impl;

import com.shujia.bean.StudentScore;
import com.shujia.dao.StudentDao;
import com.shujia.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<StudentScore> queryScoreById(String studentId) {
        ArrayList<StudentScore> scores = new ArrayList<>();
        Connection connection = DBUtil.getConnection();

        String sql = "select stu.sno,stu.sname,stu.class,cou.cno as course,sco.degree from student as stu join score as sco on stu.sno=sco.sno join course as cou on sco.cno=cou.cno where stu.sno = ?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,studentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String string = resultSet.getString(1);
                String string1 = resultSet.getString(2);
                String string2 = resultSet.getString(3);
                String string3 = resultSet.getString(4);
                int anInt = resultSet.getInt(5);

                StudentScore studentScore = new StudentScore(string, string1, string2, string3, anInt);
                scores.add(studentScore);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement);
        }
        return scores;
    }
}
