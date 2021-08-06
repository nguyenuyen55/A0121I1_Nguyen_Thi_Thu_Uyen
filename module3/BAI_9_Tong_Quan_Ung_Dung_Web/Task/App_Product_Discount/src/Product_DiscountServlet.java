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

        float result = (float) (listPrice* Discount_Percent*0.01);
        request.setAttribute("discription",description);
        request.setAttribute("listPrice",listPrice);
        request.setAttribute("discount",Discount_Percent);
        request.setAttribute("result",result);
System.err.print(description);
        request.getRequestDispatcher("WEB-INF/productDiscount/discount_Product.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
