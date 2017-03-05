package cn.edu.nju.trainingsystem.vo;

import cn.edu.nju.trainingsystem.entity.Clazz;
import cn.edu.nju.trainingsystem.entity.Expense;

import java.util.List;

/**
 * Created by tjDu on 2017/3/6.
 */
public class StuAnalysisVO {
    /**
     * 选课记录
     */
    private List<Clazz> enrollRecordList;
    /**
     * 退课记录
     */
    private List<Clazz> dropRecordList;
    /**
     * 消费记录
     */
    private List<Expense> expenseList;

    public List<Clazz> getEnrollRecordList() {
        return enrollRecordList;
    }

    public void setEnrollRecordList(List<Clazz> enrollRecordList) {
        this.enrollRecordList = enrollRecordList;
    }

    public List<Clazz> getDropRecordList() {
        return dropRecordList;
    }

    public void setDropRecordList(List<Clazz> dropRecordList) {
        this.dropRecordList = dropRecordList;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }
}
