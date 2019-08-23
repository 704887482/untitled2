package day40;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

//@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> enumeration=request.getParameterNames();
        PrintWriter printWriter=response.getWriter();
        while (enumeration.hasMoreElements()){
            String str=enumeration.nextElement();
            System.out.println(str+","+ Arrays.toString(request.getParameterValues(str)));
            printWriter.write(str+","+ Arrays.toString(request.getParameterValues(str))+"<br>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
