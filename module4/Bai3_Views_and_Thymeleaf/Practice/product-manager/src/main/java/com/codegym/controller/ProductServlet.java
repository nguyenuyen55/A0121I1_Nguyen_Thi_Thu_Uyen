//package com.codegym.controller;
//
//import model.bean.Product;
//import model.service.ProductService;
//import model.service.ProductServiceIm;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "ProductServlet", urlPatterns = "/products")
//public class ProductServlet extends HttpServlet {
//    static ProductService productServiceEmp = new ProductServiceIm();
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//                createForm(request, response);
//                break;
//            case "update":
//                updateForm(request, response);
//                break;
//            case "delete":
//                deleteForm(request,response);
//                break;
//
//            case "view":
//                break;
//            default:
//                listAll(request, response);
//        }
//    }
//
//
//
//    private void deleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("id");
//        Product product = productServiceEmp.findId(id);
//        RequestDispatcher dispatcher;
//      if(product == null){
//          dispatcher = request.getRequestDispatcher("error-404.jsp");
//      }else {
//          productServiceEmp.delete(id);
//
//
//      }
//
//          response.sendRedirect("/products");
//
//    }
//
//    private void updateForm(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("id");
//        Product product = productServiceEmp.findId(id);
//
//        RequestDispatcher dispatcher;
//        if (product == null) {
//           dispatcher = request.getRequestDispatcher("errors-404.jsp");
//        }else {
//            String nameProduct= request.getParameter("nameProduct");
//            String description= request.getParameter("description");
//            double price= Double.parseDouble(request.getParameter("price"));
//            String producer= request.getParameter("producer");
//            product.setNameProduct(nameProduct);
//            product.setDescription(description);
//            product.setPriceProduct(price);
//            product.setProducer(producer);
//            productServiceEmp.update(product,id);
//            request.setAttribute("message","Update Success");
//            dispatcher = request.getRequestDispatcher("products/edit.jsp");
//        }
//        try{
//            dispatcher.forward(request,response);
//        }catch (ServletException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    private void createForm(HttpServletRequest request, HttpServletResponse response) {
//        int numberId = (int) (Math.random() * 1000);
//        String id = "";
//        if (numberId < 10) {
//            id = "sp0" + numberId;
//        } else {
//            id = "sp" + numberId;
//        }
//
//        String nameProduct = request.getParameter("nameProduct");
//        String description = request.getParameter("description");
//        double price = Double.parseDouble(request.getParameter("price"));
//        String producer = request.getParameter("producer");
//        Product product = new Product(id, nameProduct, description, price, producer);
//        RequestDispatcher dispatcher;
//        productServiceEmp.add(product);
//
//        dispatcher = request.getRequestDispatcher("products/create.jsp");
//        request.setAttribute("message", "New customer was created");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//                showCreateProduct(request, response);
//                break;
//            case "update":
//                showUpdateProduct(request, response);
//                break;
//            case "delete":
//                showDeleteProduct(request,response);
//                break;
//            case "search":
//                searchForm(request,response);break;
//            case "view":
//                showViewProduct(request,response);
//                break;
//            default:
//                listAll(request, response);
//        }
//
//    }
//
//    private void showViewProduct(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("id");
//        Product product = productServiceEmp.findId(id);
//        RequestDispatcher dispatcher;
//        if (product == null) {
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//            request.setAttribute("product", product);
//            dispatcher = request.getRequestDispatcher("products/view.jsp");
//
//        }
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    private void showDeleteProduct(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("id");
//        Product product = productServiceEmp.findId(id);
//        RequestDispatcher dispatcher;
//        if(product == null){
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        }else {
//            productServiceEmp.delete(id);
//        }
//      try{
//          response.sendRedirect("/products");
//      }catch (IOException e){
//          e.printStackTrace();
//      }
//
//
//
//    }
//
//
//
//
//    private void showUpdateProduct(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("id");
//        Product product = productServiceEmp.findId(id);
//        RequestDispatcher dispatcher;
//        if (product == null) {
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//            request.setAttribute("product", product);
//            dispatcher = request.getRequestDispatcher("products/edit.jsp");
//
//        }
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void showCreateProduct(HttpServletRequest request, HttpServletResponse response) {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("products/create.jsp");
//
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private void searchForm(HttpServletRequest request, HttpServletResponse response) {
//        String search = request.getParameter("namesearch");
//        List<Product> products = productServiceEmp.search(search);
//
//        if(products.size()==0){
//            request.setAttribute("message","Không tìm thấy sản phẩm này");
//        }
//        int count = products.size();
//       // int endpaing=
//        int pagesize=1;//1 trang cho hai dong
//        int endPage=count/pagesize;
//        if(count % pagesize!=0){
//            endPage++;
//        }
//        request.setAttribute("endPage",endPage);
//        request.setAttribute("namesearch",search);
//        request.setAttribute("products",products);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("products/list.jsp");
//        try{
//            dispatcher.forward(request,response);
//        }catch (ServletException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    private void listAll(HttpServletRequest request, HttpServletResponse response) {
//        List<Product> products = productServiceEmp.listAll();
//        request.setAttribute("products", products);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("products/list.jsp");
//
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
