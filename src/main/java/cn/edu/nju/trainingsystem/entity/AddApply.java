package cn.edu.nju.trainingsystem.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by tjDu on 2017/3/7.
 */
@Entity
@Table(name = "add_apply", schema = "training_college")
public class AddApply {
    private String institutionId;
    private Date startTime;
    private Date endTime;
    private String courseName;
    private String teacher;
    private Double price;
    private int id;

    @Basic
    @Column(name = "institution_id", nullable = true, length = 255)
    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    @Basic
    @Column(name = "start_time", nullable = true)
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = true)
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "course_name", nullable = true, length = 255)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "teacher", nullable = true, length = 255)
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddApply addApply = (AddApply) o;

        if (id != addApply.id) return false;
        if (institutionId != null ? !institutionId.equals(addApply.institutionId) : addApply.institutionId != null)
            return false;
        if (startTime != null ? !startTime.equals(addApply.startTime) : addApply.startTime != null) return false;
        if (endTime != null ? !endTime.equals(addApply.endTime) : addApply.endTime != null) return false;
        if (courseName != null ? !courseName.equals(addApply.courseName) : addApply.courseName != null) return false;
        if (teacher != null ? !teacher.equals(addApply.teacher) : addApply.teacher != null) return false;
        if (price != null ? !price.equals(addApply.price) : addApply.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = institutionId != null ? institutionId.hashCode() : 0;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
