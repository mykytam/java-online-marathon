package com.softserve.itacademy;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users/create")
public class CreateUserServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() {
        userDao = UserDao.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Create new User</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "      <form action=\"/users/create\" method=\"post\">\n" +
                "          <table>\n" +
                "              <tr>\n" +
                "                  <td>\n" +
                "                      <label for=\"username\">Username: </label>\n" +
                "                  </td>\n" +
                "                  <td>\n" +
                "                      <input type=\"text\" id=\"username\" name=\"username\">\n" +
                "                  </td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                  <td>\n" +
                "                      <label for=\"password\">Password: </label>\n" +
                "                  </td>\n" +
                "                  <td>\n" +
                "                      <input type=\"password\" id=\"password\" name=\"password\">\n" +
                "                  </td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                  <td>\n" +
                "                      <input type=\"submit\" value=\"Create\">\n" +
                "                  </td>\n" +
                "                  <td>\n" +
                "                      <input type=\"reset\" value=\"Clear\">\n" +
                "                  </td>\n" +
                "              </tr>\n" +
                "          </table>\n" +
                "      </form>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        userDao.create(user);
        response.sendRedirect("/users/list");
    }

}