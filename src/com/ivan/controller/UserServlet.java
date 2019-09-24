package com.ivan.controller;

import com.ivan.Dao.IUserDao;
import com.ivan.Dao.Impl.UserDaoImpl;
import com.ivan.entity.User;
import com.ivan.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name="UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //输入转码，防止乱码
        req.setCharacterEncoding("UTF-8");
        //输出转码，防止乱码
        resp.setContentType("text/html;charset=UTF-8");

        String action = req.getParameter("action");   //这步别忘了获取action对象
        switch (action){
            case "register" :
                try {
                    register(req,resp);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }





    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, IOException {
        ArrayList<List> list = new ArrayList<>();
        //获取前端数据
        String u_username = req.getParameter("u_username");
        String u_password = req.getParameter("u_password");
        String u_sex = req.getParameter("u_sex");
        //注意复选框用getParameterValues函数，不然只能传入一个选的数据
        String[] u_hobbies = req.getParameterValues("u_hobbies");
        String u_phone = req.getParameter("u_phone");
        String u_email = req.getParameter("u_email");
        String u_address = req.getParameter("u_address");

        System.out.println("---------------------------");
        System.out.println(u_username);
        System.out.println(u_password);
        System.out.println(u_sex);
        System.out.println(u_hobbies);
        System.out.println(u_phone);
        System.out.println(u_email);
        System.out.println(u_address);

        if(u_username==""||u_password==""||u_sex==null||u_hobbies==null||u_phone==""||u_email==""||u_address==null){
            System.out.println("请补全信息");
            System.out.println("----------------------");
        }

        System.out.println("*********************************");
        //将数组转换为字符串
        String s = Arrays.toString(u_hobbies);
        String u_hobby = s.substring(1,s.length()-1);

        IUserDao userDao = new UserDaoImpl();
        User user = new User(u_username,u_password,u_sex,u_hobby,u_phone,u_email,u_address);
        Integer integer = userDao.addUser(user);


        if(integer>=1){
            resp.sendRedirect("login.html");
        }else{
            resp.sendRedirect("register.html");
        }


    }
}


/**
 * 重写：override  在继承关系中----方法名必须相同------参数列表相同--------------------------返回值必须相同，修饰符的权限不能比父类更保守
 * 重载：overlaod  在同类中-------方法名必须相同-------参数列表必须不同（个数，类型，顺序）----与返回值，修饰符无关
 */

