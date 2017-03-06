package cn.edu.nju.trainingsystem.dao;


import cn.edu.nju.trainingsystem.entity.Clazz;
import cn.edu.nju.trainingsystem.entity.Expense;
import cn.edu.nju.trainingsystem.entity.Student;

import java.util.List;

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

    /**
     * 花销记录
     *
     * @param username
     * @return
     */
    List<Expense> getExpenseRecord(String username);

    /**
     * 历史上所有选过的课程（包括退过的）
     *
     * @param username
     * @return
     */
    List<Clazz> getHistorySelected(String username);

    /**
     * 历史上所有退过的课程
     *
     * @param username
     * @return
     */
    List<Clazz> getHistoryDroped(String username);

    /**
     * 取消会员资格
     *
     * @param username
     * @return
     */
    boolean deleteStudent(String username);

    boolean register(Student student);
}
