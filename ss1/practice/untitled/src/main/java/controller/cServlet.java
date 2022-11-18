package controller;

import model.Customer;
import service.CustomerService;
import service.impl.SimpleCustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "cServlet",urlPatterns = "/abc")
public class cServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerService customerService = new SimpleCustomerServiceImpl();
//        List<Customer> customerList =  customerService.findAll();
//        request.setAttribute("customers",customerList);
        request.getRequestDispatcher("/list.jsp").forward(request,response);


    }
}
