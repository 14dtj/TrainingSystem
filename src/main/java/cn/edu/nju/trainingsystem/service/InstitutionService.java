package cn.edu.nju.trainingsystem.service;

import cn.edu.nju.trainingsystem.entity.Clazz;
import cn.edu.nju.trainingsystem.entity.Institution;

import java.util.List;

/**
 * Created by tjDu on 2017/3/6.
 */
public interface InstitutionService {
    /**
     * 注册机构
     *
     * @param institution
     * @return
     */
    boolean register(Institution institution);

    /**
     * 机构负责人登录
     *
     * @param id
     * @param password
     * @return
     */
    boolean login(String id, String password);

    /**
     * 获得本机构的课程
     *
     * @param id
     * @return
     */
    List<Clazz> getCourseList(String id);

    /**
     * 查看课程具体信息
     *
     * @param id
     * @return
     */
    Clazz getSpecific(String id);
}
