package com.softserve.itacademy.servlets;

import com.softserve.itacademy.model.AddressBook;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/delete")
public class DeleteRecordServlet extends HttpServlet {

    private AddressBook addressBook;

    @Override
    public void init() {
        addressBook = AddressBook.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        addressBook.delete(firstName, lastName);
        response.sendRedirect("/records/list");
    }
}
