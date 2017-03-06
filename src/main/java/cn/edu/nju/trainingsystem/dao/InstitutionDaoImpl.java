package cn.edu.nju.trainingsystem.dao;

import cn.edu.nju.trainingsystem.entity.Clazz;
import cn.edu.nju.trainingsystem.entity.Institution;
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
}
