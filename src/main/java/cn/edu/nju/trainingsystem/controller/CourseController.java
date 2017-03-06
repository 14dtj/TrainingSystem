package cn.edu.nju.trainingsystem.controller;

import cn.edu.nju.trainingsystem.entity.Apply;
import cn.edu.nju.trainingsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tjDu on 2017/2/27.
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/all")
    public String getCourseList(Model model, HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        model.addAttribute("courses", courseService.getCourseList(username));
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

    @RequestMapping(value = "/drop/{list}", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> dropCourse(@PathVariable("list") String list, HttpServletRequest request) {
        String[] array = list.split(",");
        String username = (String) request.getSession().getAttribute("username");
        courseService.dropCourse(array, username);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "success");
        return map;
    }

    @RequestMapping(value = "/selected")
    public String getSelectedCourse(Model model, HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        model.addAttribute("courses", courseService.getSelectedCourse(username));
        return "drop";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void applyAddCourse(String teacher, String price, Date start, Date end, String name,
                                 HttpServletRequest request, HttpServletResponse response) {
        String id = (String) request.getSession().getAttribute("institution");
        Apply vo = new Apply();
        vo.setCourseName(name);
        vo.setEndTime(end);
        vo.setStartTime(start);
        vo.setInstitutionId(id);
        vo.setPrice(Double.parseDouble(price));
        vo.setTeacher(teacher);
        courseService.applyAddCourse(vo);
        ResponseHelper.generateAlert(response, "申请成功！等待经理审批！");
    }
}
