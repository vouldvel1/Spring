package com.vouldvell.spring.service;

import org.springframework.stereotype.Service;
import repository.Student;
import repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

   private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
       return studentRepository.findAll();
   }

    public Student Create(Student student) {
        var studentsIsEmpty = studentRepository.findByLogin(student.getLogin());

        if(studentsIsEmpty.isPresent()) {
            throw new IllegalArgumentException(student.getLogin() + " already exists");
        }

        studentRepository.save(student);

        return student;
    }

    public void Delete(Long id) {
        var studentOptional = studentRepository.findById(id);

        if(studentOptional.isEmpty()) {
            throw new IllegalArgumentException(id + " does not exist");
        }

        studentRepository.deleteById(id);
    }
}
