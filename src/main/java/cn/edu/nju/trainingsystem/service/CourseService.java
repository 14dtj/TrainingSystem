package cn.edu.nju.trainingsystem.service;

import cn.edu.nju.trainingsystem.entity.Clazz;

import java.util.List;

/**
 * Created by tjDu on 2017/2/27.
 */
public interface CourseService {
    /**
     * 所有未选的课程
     *
     * @return
     */
    List<Clazz> getCourseList(String username);

    /**
     * 选课
     *
     * @param courseList
     * @param username
     * @return
     */
    boolean selectCourse(String[] courseList, String username);

    /**
     * 退课
     *
     * @param courseList
     * @param username
     * @return
     */
    boolean dropCourse(String[] courseList, String username);

    /**
     * 所有已选的课程
     *
     * @param username
     * @return
     */
    List<Clazz> getSelectedCourse(String username);
}
