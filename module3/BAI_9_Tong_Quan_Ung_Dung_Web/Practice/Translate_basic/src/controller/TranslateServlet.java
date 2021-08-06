package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateServlet" ,urlPatterns = "/translate")
public class TranslateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("hello","Xin chào");
        dictionary.put("how","Thế nào");
        dictionary.put("book","Sách");
        dictionary.put("love","Tình yêu");
        dictionary.put("honey","Người yêu");
        dictionary.put("Java","Java is a programming OPP");
        String search= request.getParameter("search");

        PrintWriter writer =response.getWriter();
        writer.println("<html>");

        String result = dictionary.get(search);
        if(result!=null){
            writer.println("<p>Word: "+search+"</p>");
            writer.println("<p>Result: "+result+"</p>");
        }else {
            writer.println("Not found");
        }
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
