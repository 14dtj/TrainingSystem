package cn.edu.nju.trainingsystem.entity;

import javax.persistence.*;

/**
 * Created by tjDu on 2017/3/5.
 */
@Entity
@Table(name = "grade_record", schema = "training_college")
@IdClass(GradeRecordPK.class)
public class GradeRecord {
    private Double grade;
    private String studentName;
    private String className;

    @Basic
    @Column(name = "grade", nullable = true, precision = 0)
    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }


    @Id
    @Column(name = "student_name", nullable = false, length = 11)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Id
    @Column(name = "class_name", nullable = false, length = 11)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
