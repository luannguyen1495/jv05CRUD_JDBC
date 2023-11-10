package com.ra.model.dao;

import com.ra.model.entity.Student;
import com.ra.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImp implements IGenericDAO<Student,Integer> {

    @Override
    public List<Student> findALl()  {
        Connection connection = null;
        List<Student> list = new ArrayList<>();

        try {
            // mo ket noi
            connection = ConnectionDB.getConnection();
            // chuẩn bị cau lenh truy van
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM student");
            // thuc thi
            ResultSet rs = pstm.executeQuery();

            while (rs.next()){
                Student  student = new Student();
                student.setStudentCode(rs.getInt("studentCode"));
                student.setStudentName(rs.getString("studentName"));
                student.setAge(rs.getInt("age"));
                student.setSex(rs.getBoolean("sex"));
                list.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return list;
    }

    @Override
    public Boolean save(Student student) {
        return null;
    }

    @Override
    public Student findId(Integer integer) {
        return null;
    }

    @Override
    public Boolean update(Student student, Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
