package cn.edu.nju.trainingsystem.dao;

import cn.edu.nju.trainingsystem.entity.Clazz;
import cn.edu.nju.trainingsystem.entity.Expense;
import cn.edu.nju.trainingsystem.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by tjDu on 2017/2/24.
 */
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
    @PersistenceContext
    private EntityManager em;

    public boolean login(String id, String password) {
        String sql = "from Student stu where stu.id=?1 and stu.password=?2";
        Query query = em.createQuery(sql);
        query.setParameter(1, id).setParameter(2, password);
        List users = query.getResultList();
        return users.size() != 0;
    }

    @Override
    public Student getBasicInfo(String id) {
        String sql = "from Student stu where stu.id=?1";
        Query query = em.createQuery(sql);
        query.setParameter(1, id);
        List<Student> users = query.getResultList();
        return users.get(0);
    }

    @Override
    public boolean editInfo(Student student) {
        Student old = em.find(Student.class, student.getId());
        old.setPassword(student.getPassword());
        old.setName(student.getName());
        old.setBankCard(student.getBankCard());
        return true;
    }

    @Override
    public List<Expense> getExpenseRecord(String username) {
        String sql = "from Expense ex where studentId=?1";
        Query query = em.createQuery(sql);
        query.setParameter(1, username);
        return query.getResultList();
    }

    @Override
    public List<Clazz> getHistorySelected(String username) {

        return null;
    }

    @Override
    public List<Clazz> getHistoryDroped(String username) {
        return null;
    }
}
