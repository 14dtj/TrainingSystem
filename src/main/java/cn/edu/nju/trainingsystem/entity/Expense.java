package cn.edu.nju.trainingsystem.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by tjDu on 2017/3/5.
 */
@Entity
@Table(name = "expense", schema = "training_college")
public class Expense {
    private String studentId;
    private Timestamp date;
    private Double expense;
    private int id;


    @Basic
    @Column(name = "student_id", nullable = false, length = 255)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "expense", nullable = true, precision = 0)
    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
