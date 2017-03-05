package cn.edu.nju.trainingsystem.dao;

import cn.edu.nju.trainingsystem.entity.Clazz;
import cn.edu.nju.trainingsystem.entity.DropRecord;
import cn.edu.nju.trainingsystem.entity.EnrollRecord;

import java.util.List;

/**
 * Created by tjDu on 2017/2/27.
 */
public interface CourseDao {

    List<Clazz> getCourseList(String username);

    boolean selectCourse(List<EnrollRecord> data);

    boolean dropCourse(List<DropRecord> data);

    /**
     * 当前可以退选的课程
     *
     * @param username
     * @return
     */
    List<Clazz> getSelectedCourse(String username);
}
