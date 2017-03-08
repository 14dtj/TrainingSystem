package cn.edu.nju.trainingsystem.service;

import cn.edu.nju.trainingsystem.dao.InstitutionDao;
import cn.edu.nju.trainingsystem.entity.*;
import cn.edu.nju.trainingsystem.vo.InstitutionAnalysisVO;
import cn.edu.nju.trainingsystem.vo.WithdrawVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tjDu on 2017/3/6.
 */
@Service
public class InstitutionServiceImpl implements InstitutionService {
    @Autowired
    private InstitutionDao institutionDao;

    @Override
    public boolean register(Institution institution) {
        return institutionDao.register(institution);
    }

    @Override
    public boolean login(String id, String password) {
        return institutionDao.login(id, password);
    }

    @Override
    public List<Clazz> getCourseList(String id) {
        return institutionDao.getCourseList(id);
    }

    @Override
    public Clazz getSpecific(String id) {
        return institutionDao.getSpecific(id);
    }

    @Override
    public boolean registerGrade(GradeRecord record) {
        return institutionDao.registerGrade(record);
    }

    @Override
    public boolean checkout(String studentId, String amount, String institutionId) {
        Expense expense = new Expense();
        expense.setExpense(Double.parseDouble(amount));
        expense.setStudentId(studentId);
        InstitutionPayment payment = new InstitutionPayment();
        payment.setInstitutionId(institutionId);
        payment.setPayment(Double.parseDouble(amount));
        return institutionDao.checkout(expense, payment);
    }

    @Override
    public boolean withdraw(WithdrawVO vo) {
        return institutionDao.withdraw(vo);
    }

    @Override
    public InstitutionAnalysisVO getAnalysis(String id) {
        List<EnrollRecord> enrolls = institutionDao.getEnrollRecords(id);
        List<DropRecord> drops = institutionDao.getDropRecords(id);
        List<GradeRecord> grades = institutionDao.getGradeRecords(id);
        double balance = institutionDao.getBalance(id);
        InstitutionAnalysisVO vo = new InstitutionAnalysisVO(enrolls, drops, grades, balance);
        return vo;
    }

    @Override
    public boolean recharge(String studentId, String amount, String institutionId) {
        return institutionDao.recharge(studentId, amount, institutionId);
    }

}
