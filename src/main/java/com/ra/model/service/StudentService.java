package com.ra.model.service;

import com.ra.model.dao.StudentDAOImp;
import com.ra.model.entity.Student;

import java.util.List;

public class StudentService implements IGenericService<Student,Integer> {
    private final StudentDAOImp studentDAOImp = new StudentDAOImp();
    @Override
    public List<Student> findAll() {
        return studentDAOImp.findALl();
    }

    @Override
    public Boolean save(Student student) {
        return studentDAOImp.save(student);
    }

    @Override
    public Student findId(Integer id) {
        return studentDAOImp.findId(id);
    }

    @Override
    public Boolean update(Student student, Integer id) {
        return studentDAOImp.update(student,id);
    }

    @Override
    public void delete(Integer integer) {

    }
}
