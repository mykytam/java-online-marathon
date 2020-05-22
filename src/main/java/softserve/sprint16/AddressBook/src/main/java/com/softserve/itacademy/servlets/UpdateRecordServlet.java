package com.softserve.itacademy.servlets;

import com.softserve.itacademy.model.AddressBook;
import com.softserve.itacademy.model.NameAddressPair;

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
        NameAddressPair pair = addressBook.read(firstName, lastName);
        request.setAttribute("recordToUpdate", pair);

        if (pair == null) {
            response.setStatus(404);
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/update-record.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");

        addressBook.update(firstName, lastName, address);
        response.sendRedirect("/records/list");
    }

}
