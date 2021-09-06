package controller;

import bean.Contract;
import service.IServiceContract;
import service.Impl.ImplServiceContract;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/contract")
public class ContractServlet extends HttpServlet {
    IServiceContract serviceContract = new ImplServiceContract();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                createContract(req, resp);
                break;
            default:
                showlistContract(req, resp);
        }
    }

    private void createContract(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Date dateStart = Date.valueOf(req.getParameter("dateStart"));
        Date dateEnd = Date.valueOf(req.getParameter("dateEnd"));
        Double deposit = Double.valueOf(req.getParameter("deposit"));
        Double total = Double.valueOf(req.getParameter("total"));
        int idemployee =Integer.parseInt(req.getParameter("idemployee"));
        int idcustomer =Integer.parseInt(req.getParameter("idcustomer"));
        int idservice =Integer.parseInt(req.getParameter("idservice"));
   Contract contract = new Contract(dateStart,dateEnd,deposit,total,idemployee,idcustomer,idservice);
   serviceContract.createContract(contract);
   resp.sendRedirect("/contract");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
           formCreate(req, resp);
                break;

            default:
                showlistContract(req, resp);
        }
    }

    private void formCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("contract/create.jsp").forward(req,resp);

    }

    private void showlistContract(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Contract> contracts = serviceContract.contracts();
        req.setAttribute("contracts",contracts);
        req.getRequestDispatcher("contract/list.jsp").forward(req,resp);
    }
}
