package com.softserve.itacademy.servlets;

import com.softserve.itacademy.model.AddressBook;
import com.softserve.itacademy.model.NameAddressPair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/read")
public class ReadRecordServlet extends HttpServlet {

    private AddressBook addressBook;

    @Override
    public void init() {
        addressBook = AddressBook.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        NameAddressPair mem = addressBook.read(firstName, lastName);
        request.setAttribute("record", mem);
        request.getRequestDispatcher("/WEB-INF/read-record.jsp").forward(request, response);
    }
}
