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
        String action = request.getParameter("action");
        if(action == null){
            showListStudent(request,response);
        }
        switch (action){
            case "edit":
                Integer id =  Integer.parseInt(request.getParameter("id"));
                // laya du lieu theo id
                Student student = studentService.findId(id);

                // hien thi ra form or  view jsp
                request.setAttribute("student",student);
                request.getRequestDispatcher("views/student-edit.jsp").forward(request,response);
                break;
            case "delete":
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        String studentName = request.getParameter("student_name");
        int age = Integer.parseInt(request.getParameter("age"));
        boolean sex = Boolean.parseBoolean(request.getParameter("sex"));
        if(action == null){

            studentService.save(new Student(studentName, age, sex));
            response.sendRedirect("/StudentServlet");
        }
        if(action.equals("update")){
            Integer id = Integer.parseInt(request.getParameter("studentCode"));
            Student student = new Student(id,studentName,age,sex);
            studentService.update(student,id);
            response.sendRedirect("/StudentServlet");
        }
    }

    public void showListStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Student> list = studentService.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("views/student.jsp").forward(request, response);
    }
}