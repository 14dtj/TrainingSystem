package cn.edu.nju.trainingsystem.dao;

import cn.edu.nju.trainingsystem.entity.*;
import cn.edu.nju.trainingsystem.vo.WithdrawVO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by tjDu on 2017/3/6.
 */
@Repository
@Transactional
public class InstitutionDaoImpl implements InstitutionDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean register(Institution institution) {
        String sql = "select count(*) from Institution i";
        Query query = em.createQuery(sql);
        long num = (long) query.getSingleResult();
        String id = IdGenerator.generateId((int) num + 1, 'i');
        institution.setId(id);
        em.persist(institution);
        return true;
    }

    @Override
    public boolean login(String id, String password) {
        String sql = "from Institution ins where ins.id=?1 and ins.password=?2";
        Query query = em.createQuery(sql);
        query.setParameter(1, id).setParameter(2, password);
        List users = query.getResultList();
        return users.size() != 0;
    }

    @Override
    public List<Clazz> getCourseList(String id) {
        String sql = "from Clazz c where institutionId=?1";
        Query query = em.createQuery(sql);
        query.setParameter(1, id);
        return query.getResultList();
    }

    @Override
    public Clazz getSpecific(String id) {
        return em.find(Clazz.class, Integer.parseInt(id));
    }

    @Override
    public boolean registerGrade(GradeRecord record) {
        em.persist(record);
        return true;
    }

    @Override
    public boolean checkout(Expense expense, InstitutionPayment payment) {
        em.persist(expense);
        em.persist(payment);
        Student student = em.find(Student.class, expense.getStudentId());
        student.setBalance(student.getBalance() - expense.getExpense());
        student.setPoint(student.getPoint() + expense.getExpense());
        return true;
    }

    @Override
    public boolean withdraw(WithdrawVO vo) {
        String sql = "select id from Student s where s.name=?1 ";
        Query query = em.createQuery(sql);
        query.setParameter(1, vo.studentName);
        String studentId = (String) query.getSingleResult();
        if (studentId == null) {
            return false;
        }
        sql = "select classId from Clazz c where c.courseName = ?1";
        query = em.createQuery(sql);
        query.setParameter(1, vo.courseName);
        int courseId = (int) query.getSingleResult();
        DropRecord dropRecord = new DropRecord();
        dropRecord.setInstitutionId(vo.institutionId);
        dropRecord.setStudentId(studentId);
        dropRecord.setClassId(courseId);
        em.persist(dropRecord);
        EnrollRecordPK pk = new EnrollRecordPK();
        pk.setClassId(courseId);
        pk.setStudentId(studentId);
        EnrollRecord enrollRecord = em.find(EnrollRecord.class, pk);
        if (enrollRecord == null) {
            return false;
        }
        enrollRecord.setMark((byte) 1);
        return true;
    }
}
