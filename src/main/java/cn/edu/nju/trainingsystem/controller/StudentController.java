package cn.edu.nju.trainingsystem.controller;

import cn.edu.nju.trainingsystem.entity.Student;
import cn.edu.nju.trainingsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tjDu on 2017/2/27.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request) {
        String id = (String) request.getSession().getAttribute("username");
        Student stu = studentService.getBasicInfo(id);
        model.addAttribute("stu", stu);
        return "studentHome";
    }

    @RequestMapping(value = "/basicInfo", method = RequestMethod.GET)
    public String getBasicInfo(Model model, HttpServletRequest request) {
        String id = (String) request.getSession().getAttribute("username");
        Student stu = studentService.getBasicInfo(id);
        model.addAttribute("stu", stu);
        return "editStudentInfo";
    }


    @RequestMapping(value = "/editInfo", method = RequestMethod.POST)
    public String editInfo(String name, String password, String bankcard, HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        Student vo = new Student();
        vo.setId(username);
        vo.setBankCard(bankcard);
        vo.setName(name);
        vo.setPassword(password);
        studentService.editInfo(vo);
        return "redirect:/student/basicInfo";
    }

    @RequestMapping(value = "/analysis", method = RequestMethod.GET)
    public String getAnalysisInfo(HttpServletRequest request, Model model) {
        String username = (String) request.getSession().getAttribute("username");
        model.addAttribute("model", studentService.getAnalysisInfo(username));
        return "studentAnalysis";
    }
}
