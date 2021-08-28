package controller;

import bean.DichVu;
import bean.ThongtinTiecCuoi;
import service.ImIServiceUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ThongTinServlet", urlPatterns = {"","/thongtin"})
public class ThongTinServlet extends HttpServlet {
    ImIServiceUser thongtin = new ImIServiceUser();

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
                //  showDelete(request, response);
                break;
            case "search":
                //   searchById(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void formUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThongtinTiecCuoi user = null;
        int id = Integer.parseInt(request.getParameter("id"));
        String ngayToChuc = request.getParameter("ngayToChuc");
        String tenCoDau = request.getParameter("tenCoDau");
        String tenChuRe = request.getParameter("tenChuRe");
        int soLuongBan = Integer.parseInt(request.getParameter("soLuongBan"));
        int donGia = Integer.parseInt(request.getParameter("donGia"));
        int dichVuDiKem = Integer.parseInt(request.getParameter("dichVuDiKem"));
        int tenNoDatCoc = Integer.parseInt(request.getParameter("tienNoDatCoc"));
        int tienNoThanhToan = Integer.parseInt(request.getParameter("TienNoThanhToan"));
        String ngayDatCoc = request.getParameter("ngayDatCoc");
        String ngayThanhToan = request.getParameter("NgayThanhToan");
        String ghiChu = request.getParameter("ghichu");
        String trangThai = request.getParameter("trangThai");
        thongtin.update(new ThongtinTiecCuoi(ngayToChuc, tenCoDau, tenChuRe, soLuongBan, donGia, dichVuDiKem, tenNoDatCoc, tienNoThanhToan, ngayDatCoc, ngayThanhToan, ghiChu, trangThai),id);
      response.sendRedirect("/thongtin");

    }

    private void formCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThongtinTiecCuoi user = null;
        String ngayToChuc = request.getParameter("ngayToChuc");
        String tenCoDau = request.getParameter("tenCoDau");
        String tenChuRe = request.getParameter("tenChuRe");
        int soLuongBan = Integer.parseInt(request.getParameter("soLuongBan"));
        int donGia = Integer.parseInt(request.getParameter("donGia"));
        int dichVuDiKem = Integer.parseInt(request.getParameter("dichVuDiKem"));
        int tenNoDatCoc = Integer.parseInt(request.getParameter("tienNoDatCoc"));
        int tienNoThanhToan = Integer.parseInt(request.getParameter("TienNoThanhToan"));
        String ngayDatCoc = request.getParameter("ngayDatCoc");
        String ngayThanhToan = request.getParameter("NgayThanhToan");
        String ghiChu = request.getParameter("ghichu");
        String trangThai = request.getParameter("trangThai");


        thongtin.createThongtin(new ThongtinTiecCuoi(ngayToChuc, tenCoDau, tenChuRe, soLuongBan, donGia, dichVuDiKem, tenNoDatCoc, tienNoThanhToan, ngayDatCoc, ngayThanhToan, ghiChu, trangThai));
        if(thongtin!=null) {
            request.setAttribute("message", "Bạn đã thêm thành công");
        }else {
            request.setAttribute("message", "Bạn thêm  không thành công");

        }

        request.getRequestDispatcher("thongtin/create.jsp").forward(request, response);

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
                //   searchById(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        thongtin.delete(id);
        response.sendRedirect("/thongtin");
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ThongtinTiecCuoi thongtinTiecCuoi = thongtin.selectById(id);
        List<DichVu> dichVus = thongtin.dichVuList();
        request.setAttribute("dichVus", dichVus);
        request.setAttribute("thongtin", thongtinTiecCuoi);
        request.getRequestDispatcher("thongtin/update.jsp").forward(request, response);

    }
    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DichVu> dichVus = thongtin.dichVuList();
        request.setAttribute("dichVus", dichVus);
        request.getRequestDispatcher("thongtin/create.jsp").forward(request, response);

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ThongtinTiecCuoi> thongtinTiecCuois = thongtin.thongtinList();
        List<DichVu> dichVus = thongtin.dichVuList();
        request.setAttribute("dichVus", dichVus);
        request.setAttribute("thongtins", thongtinTiecCuois);
        request.getRequestDispatcher("thongtin/list.jsp").forward(request, response);

    }
}
