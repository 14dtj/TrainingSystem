package cn.edu.nju.trainingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by tjDu on 2017/3/5.
 */
public class GradeRecordPK implements Serializable {
    private String studentName;
    private String className;

    @Column(name = "student_name", nullable = false, length = 11)
    @Id
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Column(name = "class_name", nullable = false, length = 11)
    @Id
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
