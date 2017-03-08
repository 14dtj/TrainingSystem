package cn.edu.nju.trainingsystem.dao;

import cn.edu.nju.trainingsystem.entity.*;
import cn.edu.nju.trainingsystem.vo.InstitutionStudentVO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjDu on 2017/3/8.
 */
@Repository
@Transactional
public class ManagerDaoImpl implements ManagerDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<InstitutionPayment> getPayment() {
        String sql = "from InstitutionPayment g where g.state is null";
        Query query = em.createQuery(sql);
        return query.getResultList();
    }

    @Override
    public boolean payInstitution(List<InstitutionPayment> payments) {
        for (InstitutionPayment payment : payments) {
            InstitutionPayment old = em.find(InstitutionPayment.class, payment.getId());
            old.setState("已支付");
            Institution institution = em.find(Institution.class, old.getInstitutionId());
            institution.setBalance(institution.getBalance() + payment.getPayment());
        }
        return true;
    }

    @Override
    public List<AddApply> getAddApply() {
        String sql = "from AddApply g";
        Query query = em.createQuery(sql);
        return query.getResultList();
    }

    @Override
    public List<EditApply> getEditApply() {
        String sql = "from EditApply g";
        Query query = em.createQuery(sql);
        return query.getResultList();
    }

    @Override
    public boolean approveAdd(String[] array) {
        for (String str : array) {
            AddApply addApply = em.find(AddApply.class, Integer.parseInt(str));
            if (addApply == null) {
                return false;
            }
            Clazz clazz = new Clazz();
            clazz.setCourseName(addApply.getCourseName());
            clazz.setInstitutionId(addApply.getInstitutionId());
            clazz.setStartTime(addApply.getStartTime());
            clazz.setEndTime(addApply.getEndTime());
            clazz.setTeacher(addApply.getTeacher());
            clazz.setPrice(addApply.getPrice());
            em.persist(clazz);
            em.remove(addApply);
        }
        return true;
    }

    @Override
    public boolean approveEdit(String[] array) {
        for (String str : array) {
            EditApply editApply = em.find(EditApply.class, Integer.parseInt(str));
            if (editApply == null) {
                return false;
            }
            Clazz clazz = em.find(Clazz.class, Integer.parseInt(str));
            clazz.setCourseName(editApply.getCourseName());
            clazz.setInstitutionId(editApply.getInstitutionId());
            clazz.setStartTime(editApply.getStartTime());
            clazz.setEndTime(editApply.getEndTime());
            clazz.setTeacher(editApply.getTeacher());
            clazz.setPrice(editApply.getPrice());
            em.remove(editApply);
        }
        return true;
    }

    @Override
    public List<Institution> getInstitutionList() {
        String sql = "from Institution g";
        Query query = em.createQuery(sql);
        return query.getResultList();
    }

    @Override
    public List<InstitutionStudentVO> getStudentCount() {
        String sql = "select count(*),institutionId from EnrollRecord group by institutionId";
        Query query = em.createQuery(sql);
        List<Object[]> list = query.getResultList();
        List<InstitutionStudentVO> vos = new ArrayList<>();
        for (Object[] objects : list) {
            InstitutionStudentVO vo = new InstitutionStudentVO((String) objects[1], (long) objects[0]);
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<GradeRecord> getGrades() {
        String sql = "from GradeRecord g";
        Query query = em.createQuery(sql);
        return query.getResultList();
    }
}
