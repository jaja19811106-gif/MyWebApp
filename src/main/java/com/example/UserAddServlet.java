package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.UserDAO;

@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        UserDAO dao = new UserDAO();
        dao.insertUser(name, age);

        // 登録後は一覧へリダイレクト
        response.sendRedirect("UserListServlet");
    }
}

