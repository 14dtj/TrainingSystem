package cn.edu.nju.trainingsystem.vo;

/**
 * Created by tjDu on 2017/3/8.
 */
public class InstitutionStudentVO {
    public String institutionId;
    /**
     * 该机构学员数
     */
    public long count;

    public InstitutionStudentVO(String institutionId, long count) {
        this.institutionId = institutionId;
        this.count = count;
    }
}
