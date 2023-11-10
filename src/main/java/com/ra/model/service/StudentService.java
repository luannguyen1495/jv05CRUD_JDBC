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
