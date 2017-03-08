package cn.edu.nju.trainingsystem.dao;

import cn.edu.nju.trainingsystem.entity.*;

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

    /**
     * 申请添加课程
     *
     * @param apply
     * @return
     */
    boolean addApply(AddApply apply);

    /**
     * 申请修改课程
     *
     * @param apply
     * @return
     */
    boolean editApply(EditApply apply);
}
