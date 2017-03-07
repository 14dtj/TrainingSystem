package cn.edu.nju.trainingsystem.dao;

import cn.edu.nju.trainingsystem.entity.*;
import cn.edu.nju.trainingsystem.vo.WithdrawVO;

import java.util.List;

/**
 * Created by tjDu on 2017/3/6.
 */
public interface InstitutionDao {
    boolean register(Institution institution);

    boolean login(String id, String password);

    List<Clazz> getCourseList(String id);

    Clazz getSpecific(String id);

    boolean registerGrade(GradeRecord record);

    boolean checkout(Expense expense, InstitutionPayment payment);

    boolean withdraw(WithdrawVO vo);

    List<EnrollRecord> getEnrollRecords(String institutionId);

    List<DropRecord> getDropRecords(String institutionId);

    List<GradeRecord> getGradeRecords(String institutionId);

    double getBalance(String institutionId);

}
