package cn.edu.nju.trainingsystem.service;

import cn.edu.nju.trainingsystem.dao.StudentDao;

import cn.edu.nju.trainingsystem.entity.EnrollRecord;
import cn.edu.nju.trainingsystem.entity.Student;
import cn.edu.nju.trainingsystem.vo.StuAnalysisVO;
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

    @Override
    public boolean editInfo(Student student) {
        return studentDao.editInfo(student);
    }

    @Override
    public StuAnalysisVO getAnalysisInfo(String username) {
        StuAnalysisVO vo = new StuAnalysisVO();
        vo.setDropRecordList(studentDao.getHistoryDroped(username));
        vo.setEnrollRecordList(studentDao.getHistorySelected(username));
        vo.setExpenseList(studentDao.getExpenseRecord(username));
        return vo;
    }

    @Override
    public boolean deleteStudent(String username) {
        return studentDao.deleteStudent(username);
    }

    @Override
    public boolean register(Student student) {
        return studentDao.register(student);
    }
}
