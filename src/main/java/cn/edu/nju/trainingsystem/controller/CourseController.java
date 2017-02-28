package cn.edu.nju.trainingsystem.controller;

import cn.edu.nju.trainingsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by tjDu on 2017/2/27.
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/all")
    public String getCourseList(Model model) {
        model.addAttribute("courses", courseService.getCourseList());
        return "enroll";
    }

    @RequestMapping(value = "/select/{list}", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> selectCourse(@PathVariable("list") String list, HttpServletRequest request) {
        String[] array = list.split(",");
        String username = (String) request.getSession().getAttribute("username");
        courseService.selectCourse(array, username);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "success");
        return map;
    }
}
