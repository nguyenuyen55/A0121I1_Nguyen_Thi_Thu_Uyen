import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Product_DiscountServlet" ,urlPatterns = "/display_Discount")
public class Product_DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float listPrice = Float.parseFloat(request.getParameter("listPrice"));
        float Discount_Percent = Float.parseFloat(request.getParameter("Discount_Percent"));


        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        float result = (listPrice* Discount_Percent*0.01f);
        String strDouble = String.format("%.2f", 1.23456);
        request.setAttribute("discription",description);
        request.setAttribute("listPrice",listPrice);
        request.setAttribute("discount",Discount_Percent);
        request.setAttribute("result",result);
        float discount_amount =Math.round((listPrice-result) * 100) / 100;
        request.setAttribute("discount_amount",discount_amount);
        System.err.print(description);
        request.getRequestDispatcher("WEB-INF/productDiscount/discount_Product.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
