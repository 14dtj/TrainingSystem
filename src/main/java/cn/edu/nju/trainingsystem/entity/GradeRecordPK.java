package cn.edu.nju.trainingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by tjDu on 2017/3/5.
 */
public class GradeRecordPK implements Serializable {
    private int studentId;
    private int classId;

    @Column(name = "student_id", nullable = false)
    @Id
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Column(name = "class_id", nullable = false)
    @Id
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GradeRecordPK that = (GradeRecordPK) o;

        if (studentId != that.studentId) return false;
        if (classId != that.classId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + classId;
        return result;
    }
}
