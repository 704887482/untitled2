package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

//@WebServlet("/login")
public class Demo2RefreshServlet extends HttpServlet {
    public void init() throws ServletException{
        getServletContext().setAttribute("count",0);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        ServletContext application=getServletContext();
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        if ("admin".equals(name)&&"123".equals(password)){
            int conut=(int) application.getAttribute("count");
            application.setAttribute("count",++conut);
            response.sendRedirect(request.getContextPath()+"/count");
        }else{
            out.print("<script>");
            out.print("alert('用户名或密码不正确');");
            out.print("location.href='login.html';");
            out.print("</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
