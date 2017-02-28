package cn.edu.nju.trainingsystem.dao;

import cn.edu.nju.trainingsystem.entity.Clazz;
import cn.edu.nju.trainingsystem.entity.EnrollRecord;
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
public class CourseDaoImpl implements CourseDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Clazz> getCourseList() {
        String sql = "from Clazz";
        Query query = em.createQuery(sql);
        return query.getResultList();
    }

    @Override
    @Transactional
    public boolean selectCourse(List<EnrollRecord> data) {
        for (EnrollRecord record : data) {
            em.persist(record);
        }
        return true;
    }
}
