package cn.edu.nju.trainingsystem.dao;

import cn.edu.nju.trainingsystem.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


/**
 * Created by tjDu on 2017/2/24.
 */
@Repository
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
}
