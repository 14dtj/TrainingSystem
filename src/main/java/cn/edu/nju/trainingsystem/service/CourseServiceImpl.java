package cn.edu.nju.trainingsystem.service;

import cn.edu.nju.trainingsystem.dao.CourseDao;
import cn.edu.nju.trainingsystem.entity.Clazz;
import cn.edu.nju.trainingsystem.entity.EnrollRecord;
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
    public List<Clazz> getCourseList() {
        return courseDao.getCourseList();
    }

    @Override
    public boolean selectCourse(String[] courseList, String username) {
        List<EnrollRecord> data = new ArrayList<>();
        for (String course : courseList) {
            EnrollRecord record = new EnrollRecord();
            record.setClassId(Integer.parseInt(course));
            record.setStudentId(username);
            data.add(record);
        }
        return courseDao.selectCourse(data);
    }
}
