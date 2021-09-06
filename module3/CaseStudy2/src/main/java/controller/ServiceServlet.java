package controller;

import bean.RentType;
import bean.Service;
import bean.ServiceType;
import service.IServiceCustomer;
import service.IServiceRentType;
import service.IServiceServiceType;
import service.IService_Service;
import service.Impl.ImpIServiceRentType;
import service.Impl.ImpIService_Service;
import service.Impl.ImplServiceCustomer;
import service.Impl.ImplServiceServiceType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/service"})
public class ServiceServlet extends HttpServlet {
    private IService_Service service = new ImpIService_Service();
    private IServiceServiceType serviceType = new ImplServiceServiceType();
    private IServiceRentType rentType = new ImpIServiceRentType();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addService":
                formCreate(req, resp);
                break;

            default:
                showlistService(req, resp);
        }
    }

    private void formCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nameService= req.getParameter("nameService");
        int serviceArea= Integer.parseInt(req.getParameter("serviceArea"));
        double serviceCost= Double.parseDouble(req.getParameter("serviceCost"));
        int maxpeo= Integer.parseInt(req.getParameter("serviceMaxPeo"));
        int rentId= Integer.parseInt(req.getParameter("serviceRentTypeId"));
        int serviceTypeId= Integer.parseInt(req.getParameter("serviceTypeId"));
        String standRoom =req.getParameter("standRoom");
        String description = req.getParameter("description");
        double pool= Double.parseDouble(req.getParameter("pool"));
        int number = Integer.parseInt(req.getParameter("number"));
        Service service1 = new Service(nameService,serviceArea,serviceCost,maxpeo,rentId,serviceTypeId,standRoom,description,pool,number);
        service.create(service1);
        resp.sendRedirect("/service");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addService":
                showCreateService(req, resp);
                break;

            default:
                showlistService(req, resp);
        }
    }

    private void showCreateService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ServiceType> serviceTypes = serviceType.servicetype();
        List<RentType> serviceRentTypes = rentType.rentTypes();
        req.setAttribute("a", serviceTypes);
        req.setAttribute("b", serviceRentTypes);
        req.getRequestDispatcher("service/create.jsp").forward(req, resp);
    }

    private void showlistService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Service> services = service.listService();
        req.setAttribute("services", services);
        req.getRequestDispatcher("service/list.jsp").forward(req, resp);

    }
}
