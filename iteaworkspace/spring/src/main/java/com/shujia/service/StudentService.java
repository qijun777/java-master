package com.shujia.service;

import com.shujia.bean.StudentScore;

import java.util.List;

public interface StudentService {
    public List<StudentScore> queryScoreById(String StudentId);
}
