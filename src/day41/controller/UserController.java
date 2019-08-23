package day41.controller;


import day41.pojo.User;
import day41.server.UserService;
import day41.server.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/userController")
public class UserController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        User login = userService.login(username, password);
//        PrintWriter printWriter=response.getWriter();
//        if (login != null) {
//             printWriter.write("登录成功！");
//        }
        String msg=request.getParameter("msg");
        if ("findUser".equals(msg)){
            findUser(request,response);
        }else if ("add".equals(msg)){
            add(request,response);
        }
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        userService.addUser(username,password);
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
    protected void findUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List user = userService.findUser();
        request.setAttribute("user", user);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
