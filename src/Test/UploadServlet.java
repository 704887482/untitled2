package Test;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;





public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    //上传文件存储目录
    private static final String UPLOAD_DIRECTORY="upload";
    //上传配置
    private static final int MEMORY_THRESHOLD=1024*1024*3;
    private static final int MAX_FILE_SIZE=1024*1024*40;
    private static final int MAX_REQUEST_SIZE=1024*1024*50;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(request)){
            PrintWriter writer=response.getWriter();
            writer.println("必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
        //配置上传参数
        DiskFileItemFactory factory=new DiskFileItemFactory();
        //设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload=new ServletFileUpload(factory);
        //配置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
        //设置最大请求值(包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        //中文处理
        upload.setHeaderEncoding("UTF-8");
        //构造临时路径来存储上传的文件
//        这个路径相对当前应用的目录
        String uploadPath=request.getServletContext().getRealPath("./")+File.separator+UPLOAD_DIRECTORY;
        //如果目录不存在则创建
        File uploadDir=new File(uploadPath);
        if (!uploadDir.exists()){
            uploadDir.mkdir();
        }
        try{
            //解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems=upload.parseRequest(request);
             if (formItems!=null&&formItems.size()>0){
                 for (FileItem item:formItems){
                     if (!item.isFormField()){
                         String fileName=new File(item.getName()).getName();
                         String filePath=uploadPath+File.separator+fileName;
                         File storeFile=new File(filePath);
                         System.out.println(filePath);
                         item.write(storeFile);
                         request.setAttribute("message","文件上传成功！");
                     }
                 }
             }
        }catch (Exception e){
            request.setAttribute("message",e.getMessage());
        }
        request.getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
