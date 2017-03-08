package cn.edu.nju.trainingsystem.controller;

import cn.edu.nju.trainingsystem.entity.Clazz;
import cn.edu.nju.trainingsystem.entity.GradeRecord;
import cn.edu.nju.trainingsystem.entity.Institution;
import cn.edu.nju.trainingsystem.service.InstitutionService;
import cn.edu.nju.trainingsystem.vo.InstitutionAnalysisVO;
import cn.edu.nju.trainingsystem.vo.WithdrawVO;
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

    @RequestMapping(value = "/grade/register")
    public String registerGradePage() {
        return "registerGrade";
    }

    @RequestMapping(value = "/registerGrade", method = RequestMethod.POST)
    public void registerGrade(String studentName, String courseName, String mark,
                              HttpServletResponse response) {
        GradeRecord record = new GradeRecord();
        record.setClassName(courseName);
        record.setGrade(Double.parseDouble(mark));
        record.setStudentName(studentName);
        if (institutionService.registerGrade(record)) {
            ResponseHelper.generateAlert(response, "登记成功！");
        } else {
            ResponseHelper.generateAlert(response, "登记失败！");
        }
    }

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String paymentPage() {
        return "institutionPayment";
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public void checkout(String studentId, String amount, HttpServletRequest request, HttpServletResponse response) {
        String id = (String) request.getSession().getAttribute("institution");
        if (institutionService.checkout(studentId, amount, id)) {
            ResponseHelper.generateAlert(response, "结账成功！");
        } else {
            ResponseHelper.generateAlert(response, "结账失败！");
        }
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public String withdrawPage() {
        return "registerWithdraw";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public void withdraw(String studentName, String courseName,
                         HttpServletRequest request, HttpServletResponse response) {
        String id = (String) request.getSession().getAttribute("institution");
        WithdrawVO vo = new WithdrawVO(studentName, courseName, id);
        if (institutionService.withdraw(vo)) {
            ResponseHelper.generateAlert(response, "退课成功！");
        } else {
            ResponseHelper.generateAlert(response, "退课失败！请检查学员和课程姓名是否正确！");
        }
    }

    @RequestMapping(value = "/analysis", method = RequestMethod.GET)
    public String showAnalysisInfo(Model model, HttpServletRequest request) {
        String id = (String) request.getSession().getAttribute("institution");
        InstitutionAnalysisVO vo = institutionService.getAnalysis(id);
        model.addAttribute("model", vo);
        return "institutionAnalysis";
    }

    @RequestMapping(value = "/payCard", method = RequestMethod.POST)
    public void recharge(String id, String money, HttpServletRequest request, HttpServletResponse response) {
        String institution = (String) request.getSession().getAttribute("institution");
        if (institutionService.recharge(id, money, institution)) {
            ResponseHelper.generateAlert(response, "充值成功！");
        } else {
            ResponseHelper.generateAlert(response, "充值失败！");
        }
    }
}
