package cn.edu.nju.trainingsystem.controller;

import cn.edu.nju.trainingsystem.entity.Clazz;
import cn.edu.nju.trainingsystem.entity.Institution;
import cn.edu.nju.trainingsystem.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by tjDu on 2017/3/6.
 */
@Controller
@RequestMapping("/institution")
public class InstitutionController {
    @Autowired
    private InstitutionService institutionService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "institutionHome";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(String name, String password, String balance, String manager, HttpServletResponse response) {
        Institution vo = new Institution();
        vo.setName(name);
        vo.setBalance(Double.parseDouble(balance));
        vo.setManager(manager);
        vo.setPassword(password);
        if (institutionService.register(vo)) {
            ResponseHelper.generateAlert(response, "注册成功！");
        } else {
            ResponseHelper.generateAlert(response, "注册失败！");
        }
    }

    @RequestMapping(value = "/courseList")
    public String courseList(Model model, HttpServletRequest request) {
        String id = (String) request.getSession().getAttribute("institution");
        List<Clazz> list = institutionService.getCourseList(id);
        model.addAttribute("model", list);
        return "institutionCourses";
    }

    @RequestMapping(value = "/course/{name}")
    public String courseSpecific(Model model, @PathVariable("name") String name) {
        Clazz clazz = institutionService.getSpecific(name);
        model.addAttribute("model", clazz);
        return "editCourseInfo";
    }
}
