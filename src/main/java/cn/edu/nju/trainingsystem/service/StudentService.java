package cn.edu.nju.trainingsystem.service;

import cn.edu.nju.trainingsystem.entity.Student;

/**
 * Created by tjDu on 2017/2/24.
 */
public interface StudentService {
    boolean login(String id, String password);

    /**
     * 获取学生基本信息
     *
     * @param id
     * @return
     */
    Student getBasicInfo(String id);
}
