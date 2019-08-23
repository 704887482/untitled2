package Test;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "CodeServlet",urlPatterns = "/code")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width=100;
        int height=30;
        String str="qwertyuiopasdfghjklzxcbnm123456789";
        Random random = new Random();

        BufferedImage image=new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.drawRect(0,0,100,30);
        for (int i = 0; i < 4; i++) {
            int number=random.nextInt(str.length());
            String a=str.substring(number,number+1);
            graphics.drawString(a,20*(i+1),15);
        }

        ImageIO.write(image,"jpg",resp.getOutputStream());


    }
}
