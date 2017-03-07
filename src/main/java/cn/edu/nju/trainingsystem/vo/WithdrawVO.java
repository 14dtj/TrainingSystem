package cn.edu.nju.trainingsystem.vo;

/**
 * Created by tjDu on 2017/3/7.
 */
public class WithdrawVO {
    public String studentName;
    public String courseName;
    public String institutionId;

    public WithdrawVO(String studentName, String courseName, String institutionId) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.institutionId = institutionId;
    }
}
