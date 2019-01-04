package com.shujia.service.impl;

import com.shujia.bean.StudentScore;
import com.shujia.dao.StudentDao;
import com.shujia.dao.impl.StudentDaoImpl;
import com.shujia.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<StudentScore> queryScoreById(String StudentId) {
        return studentDao.queryScoreById(StudentId);
    }
}
