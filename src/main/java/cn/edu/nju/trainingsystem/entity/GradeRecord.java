package cn.edu.nju.trainingsystem.entity;

import javax.persistence.*;

/**
 * Created by tjDu on 2017/3/5.
 */
@Entity
@Table(name = "grade_record", schema = "training_college", catalog = "")
@IdClass(GradeRecordPK.class)
public class GradeRecord {
    private int studentId;
    private int classId;
    private Double grade;

    @Id
    @Column(name = "student_id", nullable = false)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "class_id", nullable = false)
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "grade", nullable = true, precision = 0)
    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GradeRecord that = (GradeRecord) o;

        if (studentId != that.studentId) return false;
        if (classId != that.classId) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + classId;
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        return result;
    }
}
