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
 * Created by tjDu on 2017/2/23.
 */
@Controller
public class MainController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpServletRequest request) {
        if (username.startsWith("s")) {
            if (studentService.login(username, password)) {
                request.getSession().setAttribute("username", username);
                return "redirect:/student/home";
            }
        } else if (username.startsWith("i")) {
            return "hello";
        } else if (username.equals("manager")) {
            return "hello";
        } else {
            return "hello";
        }
        return "hello";
    }

}
