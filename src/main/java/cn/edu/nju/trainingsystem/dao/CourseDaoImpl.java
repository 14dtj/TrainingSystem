package cn.edu.nju.trainingsystem.dao;

import cn.edu.nju.trainingsystem.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by tjDu on 2017/2/27.
 */
@Repository
@Transactional
public class CourseDaoImpl implements CourseDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Clazz> getCourseList(String username) {
        String sql = "select c from Clazz c where c.classId not in" +
                " (select e.classId from EnrollRecord e where e.studentId=?1 and e.mark=0)";
        Query query = em.createQuery(sql);
        query.setParameter(1, username);
        return query.getResultList();
    }

    @Override
    public boolean selectCourse(List<EnrollRecord> data) {
        for (EnrollRecord record : data) {
            em.persist(record);
            em.flush();
            String sql = "insert into institution_payment(institution_id,payment) " +
                    "select e.institution_id,c.price from enroll_record e , class  c " +
                    "where c.class_id = e.class_id and e.student_id = ?1 and e.class_id =?2 ";
            Query query = em.createNativeQuery(sql);
            query.setParameter(1, record.getStudentId()).setParameter(2, record.getClassId());
            query.executeUpdate();
            sql = "insert into expense(student_id,expense) " +
                    "select e.student_id ,c.price from enroll_record e , class  c " +
                    "where c.class_id = e.class_id and e.student_id = ?1 and e.class_id =?2 ";
            query = em.createNativeQuery(sql);
            query.setParameter(1, record.getStudentId()).setParameter(2, record.getClassId());
            query.executeUpdate();
        }
        return true;
    }

    @Override
    public boolean dropCourse(List<DropRecord> data) {
        for (DropRecord record : data) {
            em.persist(record);
            EnrollRecordPK pk = new EnrollRecordPK();
            pk.setClassId(record.getClassId());
            pk.setStudentId(record.getStudentId());
            EnrollRecord er = em.find(EnrollRecord.class, pk);
            er.setMark((byte) 1);
        }
        return true;
    }

    @Override
    public List<Clazz> getSelectedCourse(String username) {
        String sql = "select c from Clazz c where c.classId in" +
                " (select e.classId from EnrollRecord e where e.studentId=?1 and e.mark=0)";
        Query query = em.createQuery(sql);
        query.setParameter(1, username);
        return query.getResultList();
    }

    @Override
    public boolean addApply(Apply apply) {
        em.persist(apply);
        return true;
    }
}
