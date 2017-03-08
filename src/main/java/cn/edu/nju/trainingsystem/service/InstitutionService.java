package cn.edu.nju.trainingsystem.service;

import cn.edu.nju.trainingsystem.entity.Clazz;
import cn.edu.nju.trainingsystem.entity.GradeRecord;
import cn.edu.nju.trainingsystem.entity.Institution;
import cn.edu.nju.trainingsystem.vo.InstitutionAnalysisVO;
import cn.edu.nju.trainingsystem.vo.WithdrawVO;

import java.util.List;

/**
 * Created by tjDu on 2017/3/6.
 */
public interface InstitutionService {
    /**
     * 注册机构
     *
     * @param institution
     * @return
     */
    boolean register(Institution institution);

    /**
     * 机构负责人登录
     *
     * @param id
     * @param password
     * @return
     */
    boolean login(String id, String password);

    /**
     * 获得本机构的课程
     *
     * @param id
     * @return
     */
    List<Clazz> getCourseList(String id);

    /**
     * 查看课程具体信息
     *
     * @param id
     * @return
     */
    Clazz getSpecific(String id);

    /**
     * 登记成绩
     *
     * @param record
     * @return
     */
    boolean registerGrade(GradeRecord record);

    /**
     * 学员结账
     *
     * @param studentId
     * @param amount
     * @return
     */
    boolean checkout(String studentId, String amount, String institutionId);

    /**
     * 学员退课
     *
     * @param vo
     * @return
     */
    boolean withdraw(WithdrawVO vo);

    /**
     * 查看机构统计信息
     *
     * @param id
     * @return
     */
    InstitutionAnalysisVO getAnalysis(String id);

    /**
     * 会员卡充值
     *
     * @param studentId
     * @param amount
     * @param institutionId
     * @return
     */
    boolean recharge(String studentId, String amount, String institutionId);
}
