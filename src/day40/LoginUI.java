package day40;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author hhy
 * @Date 2019/8/22 19:18
 */
public class LoginUI extends HttpServlet {
    private static final long serialVersionUID = 4283668589292241159L;

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String msg = req.getParameter("msg");
        PrintWriter out = resp.getWriter();
        out.append("<!DOCTYPE html>");
        out.append("<html>");
        out.append("<head>");
        out.append("<meta charset='UTF-8'>");
        out.append("<title>用户登录</title>");
        out.append("</head>");
        out.append("<body>");
        if (msg != null) {
            out.append("登录消息:" + msg);
        }
        out.append("<form action='/login' method='post'>");
        out.append("用户名： <input name='username' type='text'> <br/>");
        out.append("密码： <input name='password' type='password'> <br/>");
        out.append("<input type='submit' value='登录'>");
        out.append("</form>");
        out.append("</body>");
        out.append("</html>");
    }
}

