package com.ra.controller;

import com.ra.model.entity.Student;
import com.ra.model.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // nhaajn method get
        request.setCharacterEncoding("utf-8");
        List<Student> list = studentService.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("views/student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" poát");
        String studentName = request.getParameter("student_name");
        int age = Integer.parseInt(request.getParameter("age"));
        boolean sex = Boolean.parseBoolean(request.getParameter("sex"));
        studentService.save(new Student(studentName, age, sex));
        response.sendRedirect("/StudentServlet");
    }
}