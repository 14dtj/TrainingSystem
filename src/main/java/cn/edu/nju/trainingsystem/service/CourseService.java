package cn.edu.nju.trainingsystem.service;

import cn.edu.nju.trainingsystem.entity.Clazz;

import java.util.List;

/**
 * Created by tjDu on 2017/2/27.
 */
public interface CourseService {
    /**
     * 所有课程
     *
     * @return
     */
    List<Clazz> getCourseList();

    /**
     * 选课
     *
     * @param courseList
     * @param username
     * @return
     */
    boolean selectCourse(String[] courseList, String username);
}
