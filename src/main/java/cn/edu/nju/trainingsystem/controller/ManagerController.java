package cn.edu.nju.trainingsystem.controller;

import cn.edu.nju.trainingsystem.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tjDu on 2017/3/8.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/home")
    public String homePage() {
        return "managerHome";
    }

    @RequestMapping(value = "/pay")
    public String paymentPage(Model model) {
        model.addAttribute("model", managerService.getPayment());
        return "managerPayment";
    }

    @RequestMapping(value = "/pay/{list}", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> payInstitution(@PathVariable String list) {
        String[] array = list.split(",");
        Map<String, Object> map = new HashMap<>();
        if (managerService.payInstitution(array)) {
            map.put("msg", "结算成功！");
        } else {
            map.put("msg", "结算失败！");
        }
        return map;
    }

    @RequestMapping(value = "/examine")
    public String examinePage(Model model) {
        model.addAttribute("addApply", managerService.getAddApply());
        model.addAttribute("editApply", managerService.getEditApply());
        return "managerExamine";
    }

    @RequestMapping(value = "/examineAdd/{list}", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> approveAddApply(@PathVariable String list) {
        Map<String, Object> map = new HashMap<>();
        if (managerService.approveAdd(list.split(","))) {
            map.put("msg", "审批成功！");
        } else {
            map.put("msg", "审批失败！");
        }
        return map;
    }

    @RequestMapping(value = "/examineEdit/{list}", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> approveEditApply(@PathVariable String list) {
        Map<String, Object> map = new HashMap<>();
        if (managerService.approveEdit(list.split(","))) {
            map.put("msg", "审批成功！");
        } else {
            map.put("msg", "审批失败！");
        }
        return map;
    }

    @RequestMapping(value = "/finance")
    public String financePage(Model model) {
        model.addAttribute("model", managerService.showBalance());
        return "managerFinance";
    }

    @RequestMapping(value = "/analysis")
    public String analysisPage(Model model) {
        model.addAttribute("institution", managerService.getStudentCount());
        model.addAttribute("grades", managerService.getGrades());
        return "managerAnalysis";
    }
}
