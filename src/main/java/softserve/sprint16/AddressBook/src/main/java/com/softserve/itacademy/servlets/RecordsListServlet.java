package com.softserve.itacademy.servlets;

import com.softserve.itacademy.model.AddressBook;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.softserve.itacademy.model.SortOrder.ASC;
import static com.softserve.itacademy.model.SortOrder.DESC;

@WebServlet("/records/list")
public class RecordsListServlet extends HttpServlet {

    private AddressBook addressBook;

    @Override
    public void init() {
        addressBook = AddressBook.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/record-list.jsp");

        if (request.getParameter("sort") == null) {
            request.setAttribute("records", addressBook);
        } else if (request.getParameter("sort").equals("asc")) {
            addressBook.sortedBy(ASC);
            request.setAttribute("records", addressBook);
        } else if (request.getParameter("sort").equals("desc")) {
            addressBook.sortedBy(DESC);
            request.setAttribute("records", addressBook);
        }

        requestDispatcher.forward(request, response);
    }
}
