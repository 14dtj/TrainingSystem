package cn.edu.nju.trainingsystem.entity;

import javax.persistence.*;

/**
 * Created by tjDu on 2017/3/5.
 */
@Entity
@Table(name = "drop_record", schema = "training_college")
@IdClass(DropRecordPK.class)
public class DropRecord {
    private String studentId;
    private int classId;
    private String institutionId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DropRecord that = (DropRecord) o;

        if (classId != that.classId) return false;
        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (institutionId != null ? !institutionId.equals(that.institutionId) : that.institutionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + classId;
        result = 31 * result + (institutionId != null ? institutionId.hashCode() : 0);
        return result;
    }
}
