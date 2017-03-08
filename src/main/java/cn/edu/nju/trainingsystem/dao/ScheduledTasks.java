package cn.edu.nju.trainingsystem.dao;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 * Created by tjDu on 2017/3/8.
 */
@Component
public class ScheduledTasks {
    @PersistenceContext
    private EntityManager em;

    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public void update() {
        System.out.println("执行更新任务.....");
        String sql = "update student s set s.state ='pause' where s.state='activated' and s.balance<1000 " +
                "and YEAR(CURDATE())-YEAR(s.lastRechargeDate)>=1";
        Query query = em.createNativeQuery(sql);
        query.executeUpdate();
        sql = "delete student s where s.state='pause' and YEAR(CURDATE())-YEAR(s.lastRechargeDate)>=2";
        query = em.createNativeQuery(sql);
        query.executeUpdate();
    }
}
