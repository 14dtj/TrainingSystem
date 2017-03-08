package cn.edu.nju.trainingsystem.service;

import cn.edu.nju.trainingsystem.entity.*;
import cn.edu.nju.trainingsystem.vo.InstitutionStudentVO;

import java.util.List;

/**
 * Created by tjDu on 2017/3/8.
 */
public interface ManagerService {
    /**
     * 获得所有未结算账单
     *
     * @return
     */
    List<InstitutionPayment> getPayment();

    /**
     * 支付结算给机构
     *
     * @param array
     * @return
     */
    boolean payInstitution(String[] array);

    /**
     * 获得添加课程的申请
     *
     * @return
     */
    List<AddApply> getAddApply();

    /**
     * 获得修改课程的申请
     *
     * @return
     */
    List<EditApply> getEditApply();

    /**
     * 通过添加课程的申请
     *
     * @param array
     * @return
     */
    boolean approveAdd(String[] array);

    /**
     * 通过修改课程的申请
     *
     * @param array
     * @return
     */
    boolean approveEdit(String[] array);

    /**
     * 得到所有机构的余额信息
     *
     * @return
     */
    List<Institution> showBalance();

    /**
     * 所有机构招生情况
     *
     * @return
     */
    List<InstitutionStudentVO> getStudentCount();

    /**
     * 所有学员成绩
     *
     * @return
     */
    List<GradeRecord> getGrades();
}
