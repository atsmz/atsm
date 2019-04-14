package com.zy.atsm.controller;

import com.zy.atsm.entity.StudentInfo;
import com.zy.atsm.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class StudentController {
    @Autowired
    IStudentService studentService;


    /**
     * 显示个人信息
     * @param model
     * @param request
     * @return
     */
    @RequestMapping({"/showStuInfo"})
    public String showStudentInfo(Model model,HttpServletRequest request) {

        Integer id = (Integer) request.getSession().getAttribute("id");

        List<StudentInfo> list = studentService.showStudentInfo(id);

        model.addAttribute("STUDENT_LIST", list);

        return "mymessage";

    }

    @RequestMapping("/login")
    public String login() {
        //跳转到html
        return "login";

    }

    /**
     * 登陆操作
     * @param username
     * @param password
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/addLogin")
    public String addLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) throws Exception{

        response.setContentType("text/html;charset=gb2312");

        PrintWriter out = response.getWriter();
        //根据学生ID进行账号验证
        int id = Integer.parseInt(username);

        List<StudentInfo> list = studentService.showStudentInfo(id);

        if (list.size() > 0) {

            StudentInfo info = list.get(0);

            if (info.getStudentPassword().equals(password)) {
                //登陆成功
                request.getSession().setAttribute("username", info.getStudentName());

                request.getSession().setAttribute("id",info.getId());
                //跳转到显示我的信息方法
                return "redirect:/showStuInfo";
            }
        } else {
            out.print("<script language=\"javascript\">alert('对不起账号或者密码错误')</script>");
        }
            return null;

    }

}
