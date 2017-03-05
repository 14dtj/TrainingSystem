package cn.edu.nju.trainingsystem.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by tjDu on 2017/3/5.
 */
@Entity
public class Student {
    private String id;
    private String password;
    private String bankCard;
    private Double balance;
    private Integer level;
    private Double point;
    private String name;
    private Date lastRechargeDate;
    private String state;

    @Id
    @Column(name = "id", nullable = false, length = 255)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "bankCard", nullable = true, length = 255)
    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    @Basic
    @Column(name = "balance", nullable = true, precision = 0)
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "level", nullable = true)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "point", nullable = true, precision = 0)
    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "lastRechargeDate", nullable = true)
    public Date getLastRechargeDate() {
        return lastRechargeDate;
    }

    public void setLastRechargeDate(Date lastRechargeDate) {
        this.lastRechargeDate = lastRechargeDate;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 255)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != null ? !id.equals(student.id) : student.id != null) return false;
        if (password != null ? !password.equals(student.password) : student.password != null) return false;
        if (bankCard != null ? !bankCard.equals(student.bankCard) : student.bankCard != null) return false;
        if (balance != null ? !balance.equals(student.balance) : student.balance != null) return false;
        if (level != null ? !level.equals(student.level) : student.level != null) return false;
        if (point != null ? !point.equals(student.point) : student.point != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (lastRechargeDate != null ? !lastRechargeDate.equals(student.lastRechargeDate) : student.lastRechargeDate != null)
            return false;
        if (state != null ? !state.equals(student.state) : student.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (bankCard != null ? bankCard.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (point != null ? point.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastRechargeDate != null ? lastRechargeDate.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
