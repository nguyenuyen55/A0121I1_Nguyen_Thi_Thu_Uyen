package controller;

import bean.Employee;
import service.IServiceEmployee;
import service.Impl.ImplServiceEmployee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
    private IServiceEmployee serviceEmployee = new ImplServiceEmployee();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                try {
                    createEmpl(req, resp);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "update":
                update(req,resp);
                break;
            case "delete":
                break;
            case "seach":
                break;
            default:
                showlist(req, resp);

        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("nameEmployee");
        Date birthday = Date.valueOf(req.getParameter("birthDay"));
        String idcard = req.getParameter("idCard");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int position = Integer.parseInt(req.getParameter("positionId"));
        int educationid = Integer.parseInt(req.getParameter("educationId"));
        int division = Integer.parseInt(req.getParameter("division"));
        Employee employee = new Employee(name, birthday, idcard, salary, phone, email, address, position, educationid, division);
        int id= Integer.parseInt(req.getParameter("id"));
        serviceEmployee.updateEmp(employee,id);
        resp.sendRedirect("/employee");

    }

    private void createEmpl(HttpServletRequest req, HttpServletResponse resp) throws ParseException, IOException {
        String name = req.getParameter("nameEmployee");
        Date birthday = Date.valueOf(req.getParameter("birthDay"));
        String idcard = req.getParameter("idCard");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int position = Integer.parseInt(req.getParameter("positionId"));
        int educationid = Integer.parseInt(req.getParameter("educationId"));
        int division = Integer.parseInt(req.getParameter("division"));
        Employee employee = new Employee(name, birthday, idcard, salary, phone, email, address, position, educationid, division);
        serviceEmployee.addEmp(employee);
        resp.sendRedirect("/employee");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showCreate(req, resp);
                break;
            case "update":
                showUpdate(req,resp);
                break;
            case "delete":
                delete(req,resp);
                break;
            case "search":
                searchbyName(req,resp);
                break;
            default:
                showlist(req, resp);

        }
    }

    private void searchbyName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search= req.getParameter("search");
        List<Employee> employees = serviceEmployee.search(search);
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("employee/list.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id =Integer.parseInt(req.getParameter("id"));
        serviceEmployee.deleteEmp(id);
        resp.sendRedirect("/employee");
    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee em= serviceEmployee.selectById(id);
        req.setAttribute("employee",em);
        req.getRequestDispatcher("employee/update.jsp").forward(req, resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("employee/create.jsp").forward(req, resp);


    }

    private void showlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = serviceEmployee.employees();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("employee/list.jsp").forward(req, resp);

    }
}
