package cn.edu.nju.trainingsystem.dao;

import cn.edu.nju.trainingsystem.entity.Clazz;
import cn.edu.nju.trainingsystem.entity.Institution;

import java.util.List;

/**
 * Created by tjDu on 2017/3/6.
 */
public interface InstitutionDao {
    boolean register(Institution institution);

    boolean login(String id, String password);

    List<Clazz> getCourseList(String id);

    Clazz getSpecific(String id);
}
