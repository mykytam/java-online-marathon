package com.softserve.itacademy.servlets;

import com.softserve.itacademy.model.AddressBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/update")
public class UpdateRecordServlet extends HttpServlet {

    private AddressBook addressBook;

    @Override
    public void init() {
        addressBook = AddressBook.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        addressBook.read(firstName, lastName);
        request.setAttribute("recordToUpdate", addressBook);
        request.getRequestDispatcher("/WEB-INF/update-record.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");

        addressBook.update(firstName, lastName, address);
        response.sendRedirect("/records/list");
    }

}
