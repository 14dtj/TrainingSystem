package cn.edu.nju.trainingsystem.dao;

import cn.edu.nju.trainingsystem.entity.Clazz;
import cn.edu.nju.trainingsystem.entity.EnrollRecord;

import java.util.List;

/**
 * Created by tjDu on 2017/2/27.
 */
public interface CourseDao {
    /**
     * 所有课程
     *
     * @return
     */
    List<Clazz> getCourseList();

    boolean selectCourse(List<EnrollRecord> data);
}
