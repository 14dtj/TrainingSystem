package cn.edu.nju.trainingsystem.service;

import cn.edu.nju.trainingsystem.dao.StudentDao;
import cn.edu.nju.trainingsystem.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tjDu on 2017/2/24.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;


    @Override
    public boolean login(String id, String password) {
        return studentDao.login(id, password);
    }

    @Override
    public Student getBasicInfo(String id) {
        return studentDao.getBasicInfo(id);
    }
}
