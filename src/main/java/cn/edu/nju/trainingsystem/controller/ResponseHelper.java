package cn.edu.nju.trainingsystem.controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tjDu on 2017/3/6.
 */
public class ResponseHelper {
    public static void generateAlert(HttpServletResponse response, String msg) {
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().write("<script>alert('" + msg + "');history.go(-1);</script>");
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
