package com.vouldvell.spring.service.impl;

import com.vouldvell.spring.Model.Student;
import com.vouldvell.spring.service.StudentService;
import org.springframework.stereotype.Service;
import repository.*;

import java.util.List;

@Service
public class InMemoryStudentServiceImpl implements StudentService {

    private final InMemoryStudentDAO repository;

    public InMemoryStudentServiceImpl() {
        this(null);
    }

    public InMemoryStudentServiceImpl(InMemoryStudentDAO repository) {
        this.repository = repository;
    }

    @Override
    public Student CreateAccount(Student student){
        return repository.CreateAccount(student);
    }


    @Override
    public List<Student> FindAllStudents() {
        return repository.FindAllStudents();
    }
    @Override
    public Student SetInfoStudent(String login, String password, Student student) {
        return repository.SetInfoStudent(login, password, student);
    }
    @Override
    public Student findByEmail(String email) {
        return repository.findByEmail(email);
    }
    @Override
    public Student findByID(int id) {
        return repository.findById(id);
    }
    @Override
    public Student updateStudent(Student student) {
        return repository.updateStudent(student);
    }
    @Override
    public void deleteStudent(int id) {
        repository.deleteStudent(id);

    }


}
