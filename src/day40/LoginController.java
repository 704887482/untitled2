package day40;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author hhy
 * @Date 2019/8/22 19:21
 */
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println("用户名："+username+",密码：："+password);
        resp.sendRedirect(req.getContextPath()+"/to_login?msg=登录失败");
    }
}
