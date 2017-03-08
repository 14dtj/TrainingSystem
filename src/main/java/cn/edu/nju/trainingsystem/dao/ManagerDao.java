package cn.edu.nju.trainingsystem.dao;

import cn.edu.nju.trainingsystem.entity.*;
import cn.edu.nju.trainingsystem.vo.InstitutionStudentVO;

import java.util.List;

/**
 * Created by tjDu on 2017/3/8.
 */
public interface ManagerDao {
    List<InstitutionPayment> getPayment();

    boolean payInstitution(List<InstitutionPayment> payments);

    List<AddApply> getAddApply();

    List<EditApply> getEditApply();

    boolean approveAdd(String[] array);

    boolean approveEdit(String[] array);

    List<Institution> getInstitutionList();

    List<InstitutionStudentVO> getStudentCount();

    List<GradeRecord> getGrades();
}
