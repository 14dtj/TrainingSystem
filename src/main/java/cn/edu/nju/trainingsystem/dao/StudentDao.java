package cn.edu.nju.trainingsystem.dao;


import cn.edu.nju.trainingsystem.entity.Student;

/**
 * Created by tjDu on 2017/2/24.
 */
public interface StudentDao {
    boolean login(String id, String password);

    /**
     * 获得学生基本信息
     *
     * @param id
     * @return
     */
    Student getBasicInfo(String id);

    boolean editInfo(Student student);
}
