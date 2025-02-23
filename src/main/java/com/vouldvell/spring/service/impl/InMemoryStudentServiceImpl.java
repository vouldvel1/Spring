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
    public List<Student> FindAllStudents() {
        return repository.FindAllStudents();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.saveStudent(student);
    }

    @Override
    public Student findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.updateStudent(student);
    }

    @Override
    public void deleteStudent(String email) {
        repository.deleteStudent(email);

    }


}
