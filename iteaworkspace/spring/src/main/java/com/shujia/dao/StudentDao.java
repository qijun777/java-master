package com.shujia.dao;

import com.shujia.bean.StudentScore;

import java.util.List;

public interface StudentDao {
    public List<StudentScore> queryScoreById(String studentId);
}
