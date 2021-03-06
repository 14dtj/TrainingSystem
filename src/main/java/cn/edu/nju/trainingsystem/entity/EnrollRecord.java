package cn.edu.nju.trainingsystem.entity;

import javax.persistence.*;

/**
 * Created by tjDu on 2017/3/5.
 */
@Entity
@Table(name = "enroll_record", schema = "training_college")
@IdClass(EnrollRecordPK.class)
public class EnrollRecord {
    private String studentId;
    private int classId;
    private String institutionId;
    private byte mark;

    @Id
    @Column(name = "student_id", nullable = false, length = 255)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
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
    @Column(name = "institution_id", nullable = true, length = 255)
    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    @Basic
    @Column(name = "mark", nullable = false)
    public byte getMark() {
        return mark;
    }

    public void setMark(byte mark) {
        this.mark = mark;
    }
}
