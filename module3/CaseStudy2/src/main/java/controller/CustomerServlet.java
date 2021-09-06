package controller;

import bean.Customer;
import bean.CustomerType;
import service.IServiceCustomer;
import service.Impl.ImplServiceCustomer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

@WebServlet({"/customer"})
public class CustomerServlet extends HttpServlet {
    private IServiceCustomer customer =  new ImplServiceCustomer();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null)
        {
            action="";
        }
        switch (action){
            case "addCustomer":
                formCreate(req,resp);
                break;
            case "updateCustomer":
                formUpdate(req,resp);
                break;
            case "deleteCustomer":break;
            default:
                showlistCustomer(req,resp);
        }
    }

    private void formUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int customerTypeId = Integer.parseInt(req.getParameter("serviceCus"));
        String customerName = req.getParameter("nameCustomer");
        String birthdayCus = req.getParameter("birthdayCus");
        int gender = Integer.parseInt(req.getParameter("gender"));
        String cusCardId = req.getParameter("cardCus");
        String phoneCus = req.getParameter("phoneCus");
        String emailCus = req.getParameter("emailCus");
        String addressCus = req.getParameter("addressCus");
        Customer cus = new Customer(id,customerTypeId,customerName,birthdayCus,gender,cusCardId,phoneCus,emailCus,addressCus);
        customer.update(cus,id);
        resp.sendRedirect("/customer");
    }

    private void formCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
     int customerTypeId = Integer.parseInt(req.getParameter("serviceCus"));
     String customerName = req.getParameter("nameCustomer");
     String birthdayCus = req.getParameter("birthdayCus");
     int gender = Integer.parseInt(req.getParameter("gender"));
     String cusCardId = req.getParameter("idCard");
     String phoneCus = req.getParameter("phoneCus");
     String emailCus = req.getParameter("emailCus");
     String addressCus = req.getParameter("addressCus");
     customer.addNewCustomer(new Customer(customerTypeId,customerName,birthdayCus,gender,cusCardId,phoneCus,emailCus,addressCus));
//(int customer_type_id, String customer_name, String customer_birthday, int customer_gender, String customer_id_card, String customer_phone, String customer_email, String customer_address) {
    resp.sendRedirect("/customer");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null)
        {
            action="";
        }
        switch (action){
            case "addCustomer":
                showCreate(req,resp);
                break;
            case "updateCustomer":
                showUpdate(req,resp);
                break;
            case "deleteCustomer":
                showDelete(req,resp);
                break;
            case "searchCus":
                searchCus(req,resp);

                break;
            default:
                showlistCustomer(req,resp);
        }
    }

    private void searchCus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("search");
        List<Customer>  customers = customer.searchByName(name);
        req.setAttribute("customers",customers);
        req.getRequestDispatcher("customer/list.jsp").forward(req,resp);

    }

    private void showDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        customer.delete(id);
        resp.sendRedirect("/customer");
    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customerid =customer.selectById(id);
        List<CustomerType>  customerTypes = customer.customer_types();
        req.setAttribute("customerTypes",customerTypes);
        req.setAttribute("customer",customerid);
        req.getRequestDispatcher("/customer/update.jsp").forward(req,resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CustomerType>  customerTypes = customer.customer_types();
        req.setAttribute("customerTypes",customerTypes);
        req.getRequestDispatcher("/customer/create.jsp").forward(req,resp);
    }

    private void showlistCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer>  customers = customer.customer_list();
        req.setAttribute("customers",customers);
        req.getRequestDispatcher("customer/list.jsp").forward(req,resp);

    }
}
