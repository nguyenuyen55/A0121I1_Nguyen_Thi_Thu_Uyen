package controller;

import bean.User;
import service.IServiceUser;
import service.ImIServiceUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private IServiceUser imIServiceUser = new ImIServiceUser();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                formCreate(request, response);
                break;
            case "update":
                formUpdate(request, response);
                break;
            case "delete":
                break;
            default:
                showList(request, response);
        }
    }

    private void formUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        int id = Integer.parseInt(request.getParameter("id"));

        imIServiceUser.update(new User(id, name, email, country));
        response.sendRedirect("/users");
    }

    private void formCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        imIServiceUser.createUser(new User(name, email, country));
        request.setAttribute("message", "Bạn đã thêm thành công");
        request.getRequestDispatcher("users/create.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "update":
                showUpdate(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            case "search":
                searchById(request, response);
                break;
            case "permision":
                addUserPermision(request, response);
                break;
            case "test-without-tran":
                testWithoutTran(request, response);
                break;
            case "test-use-tran":
                testUseTran(request, response);
                break;

            default:
                showList(request, response);
        }
    }
    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {

        imIServiceUser.insertUpdateUseTransaction();

    }
    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {

        User user = new User("kien", "kienhoang@gmail.com", "vn");

        int[] permision = {1, 2, 4};

        imIServiceUser.addUserTransaction(user, permision);

    }

    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {

        imIServiceUser.insertUpdateWithoutTransaction();

    }

    private void searchById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("searchId"));
        User user = imIServiceUser.searchById(id);
        request.setAttribute("usersId", user);
        request.getRequestDispatcher("users/list.jsp").forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (imIServiceUser.delete(id)) {
            request.setAttribute("messageDel", "Xoá Thành công");
        } else {
            request.setAttribute("messageDel", "Xoá không  Thành công");
        }
        request.setAttribute("users", imIServiceUser.users());
        request.getRequestDispatcher("users/list.jsp").forward(request, response);
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user", imIServiceUser.selectById(id));
        request.getRequestDispatcher("users/update.jsp").forward(request, response);
    }


    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("users/create.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = imIServiceUser.users();
        request.setAttribute("users", users);
        request.getRequestDispatcher("users/list.jsp").forward(request, response);
    }
}
