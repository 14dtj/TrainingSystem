package cn.edu.nju.trainingsystem.vo;

import cn.edu.nju.trainingsystem.entity.DropRecord;
import cn.edu.nju.trainingsystem.entity.EnrollRecord;
import cn.edu.nju.trainingsystem.entity.GradeRecord;

import java.util.List;

/**
 * Created by tjDu on 2017/3/7.
 */
public class InstitutionAnalysisVO {

    /**
     * 选课记录
     */
    public List<EnrollRecord> enrollRecords;
    /**
     * 退课记录
     */
    public List<DropRecord> dropRecords;
    /**
     * 成绩情况
     */
    public List<GradeRecord> gradeRecords;
    /**
     * 余额
     */
    public double balance;

    public InstitutionAnalysisVO(List<EnrollRecord> enrollRecords, List<DropRecord> dropRecords, List<GradeRecord> gradeRecords, double balance) {
        this.enrollRecords = enrollRecords;
        this.dropRecords = dropRecords;
        this.gradeRecords = gradeRecords;
        this.balance = balance;
    }
}
