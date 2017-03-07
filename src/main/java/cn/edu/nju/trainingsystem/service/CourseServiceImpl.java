package cn.edu.nju.trainingsystem.service;

import cn.edu.nju.trainingsystem.dao.CourseDao;
import cn.edu.nju.trainingsystem.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjDu on 2017/2/27.
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Clazz> getCourseList(String username) {
        return courseDao.getCourseList(username);
    }

    @Override
    public boolean selectCourse(String[] courseList, String username) {
        List<EnrollRecord> data = new ArrayList<>();
        for (String str : courseList) {
            EnrollRecord record = new EnrollRecord();
            String[] strs = str.split(":");
            record.setClassId(Integer.parseInt(strs[0]));
            record.setInstitutionId(strs[1]);
            record.setStudentId(username);
            data.add(record);
        }
        return courseDao.selectCourse(data);
    }

    @Override
    public boolean dropCourse(String[] courseList, String username) {
        List<DropRecord> data = new ArrayList<>();
        for (String str : courseList) {
            DropRecord record = new DropRecord();
            String[] strs = str.split(":");
            record.setClassId(Integer.parseInt(strs[0]));
            record.setInstitutionId(strs[1]);
            record.setStudentId(username);
            data.add(record);
        }
        return courseDao.dropCourse(data);
    }

    @Override
    public List<Clazz> getSelectedCourse(String username) {
        return courseDao.getSelectedCourse(username);
    }

    @Override
    public boolean applyAddCourse(AddApply apply) {
        return courseDao.addApply(apply);
    }

    @Override
    public boolean applyEditCourse(EditApply apply) {
        return courseDao.editApply(apply);
    }

    @Override
    public boolean editCourse(Clazz clazz) {
        return courseDao.editCourse(clazz);
    }
}
