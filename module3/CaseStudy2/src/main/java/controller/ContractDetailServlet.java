package controller;

import bean.Contract;
import bean.ContractDetail;
import service.IServiceContract;
import service.IServiceContractDetail;
import service.Impl.ImplServiceContract;
import service.Impl.ImplServiceContractDetail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/contractDetail")
public class ContractDetailServlet extends HttpServlet {
    IServiceContractDetail serviceContractDetail = new ImplServiceContractDetail();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                createContractFrom(req, resp);
                break;
            default:
                showContractDetail(req, resp);
        }
    }

    private void createContractFrom(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    int idContract = Integer.parseInt(req.getParameter("idContract"));
    int idservice = Integer.parseInt(req.getParameter("idservice"));
    int quantity = Integer.parseInt(req.getParameter("quantity"));
    ContractDetail contractDetail= new ContractDetail(idContract,idservice,quantity);
    serviceContractDetail.createContract(contractDetail);
    resp.sendRedirect("/contractDetail");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                createFrom(req, resp);
                break;
            default:
                showContractDetail(req, resp);
        }
    }

    private void createFrom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("contractDetail/create.jsp").forward(req,resp);
    }

    private void showContractDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ContractDetail> contracts = serviceContractDetail.contractDetails();
        req.setAttribute("contracts",contracts);
        req.getRequestDispatcher("contractDetail/list.jsp").forward(req,resp);

    }
}
