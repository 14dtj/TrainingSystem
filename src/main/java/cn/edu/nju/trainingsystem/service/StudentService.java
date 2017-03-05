package cn.edu.nju.trainingsystem.service;

import cn.edu.nju.trainingsystem.entity.Student;
import cn.edu.nju.trainingsystem.vo.StuAnalysisVO;

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

    /**
     * 修改学生信息
     *
     * @param student
     * @return
     */
    boolean editInfo(Student student);

    /**
     * 获取学生统计信息
     *
     * @param username
     * @return
     */
    StuAnalysisVO getAnalysisInfo(String username);
}
