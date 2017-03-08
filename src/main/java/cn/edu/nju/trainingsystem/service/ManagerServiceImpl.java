package cn.edu.nju.trainingsystem.service;

import cn.edu.nju.trainingsystem.dao.ManagerDao;
import cn.edu.nju.trainingsystem.entity.*;
import cn.edu.nju.trainingsystem.vo.InstitutionStudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjDu on 2017/3/8.
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;

    @Override
    public List<InstitutionPayment> getPayment() {
        return managerDao.getPayment();
    }

    @Override
    public boolean payInstitution(String[] array) {
        List<InstitutionPayment> payments = new ArrayList<>();
        for (String str : array) {
            String[] strs = str.split(":");
            int id = Integer.parseInt(strs[0]);
            double payment = Double.parseDouble(strs[1]);
            InstitutionPayment entity = new InstitutionPayment();
            entity.setPayment(payment);
            entity.setId(id);
            payments.add(entity);
        }
        return managerDao.payInstitution(payments);
    }

    @Override
    public List<AddApply> getAddApply() {
        return managerDao.getAddApply();
    }

    @Override
    public List<EditApply> getEditApply() {
        return managerDao.getEditApply();
    }

    @Override
    public boolean approveAdd(String[] array) {
        return managerDao.approveAdd(array);
    }

    @Override
    public boolean approveEdit(String[] array) {
        return managerDao.approveEdit(array);
    }

    @Override
    public List<Institution> showBalance() {
        return managerDao.getInstitutionList();
    }

    @Override
    public List<InstitutionStudentVO> getStudentCount() {
        return managerDao.getStudentCount();
    }

    @Override
    public List<GradeRecord> getGrades() {
        return managerDao.getGrades();
    }
}
