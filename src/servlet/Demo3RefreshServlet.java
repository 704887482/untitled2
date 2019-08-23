package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.net.URLEncoder;

@WebServlet("/demo")
@MultipartConfig
public class Demo3RefreshServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String filename=request.getParameter("filename");
////        System.out.println(new String(filename.getBytes("iso-8859-1"),"utf-8"));
//        System.out.println(URLEncoder.encode(filename,"utf-8"));
//        System.out.println(filename);
//        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(filename
//        ,"utf-8"));
//        InputStream in=getServletContext().getResourceAsStream("/download/"+filename);
//        System.out.println(in);
//        OutputStream out=response.getOutputStream();
//        int len=0;
//        byte[] b=new byte[1024];
//        while((len=in.read(b))!=-1){
//            out.write(b,0,len);
//        }
//        in.close();
//        out.close();
        //创建目录
        File path = new File("d:\\tmp");
//        if (!path.exists()){
//            path.mkdir();
//        }
        //获取文件
        Part img = request.getPart("bb");
        //文件全路径
        String filePath = path.getPath() + File.separator + img.getSubmittedFileName();
        System.out.println("                           "+img.getSubmittedFileName());
        //写入文件
        img.write(filePath);
        //输出信息
        System.out.println("File Upload : " + filePath);
        PrintWriter out = response.getWriter();
        out.println("File Upload : " + filePath);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
