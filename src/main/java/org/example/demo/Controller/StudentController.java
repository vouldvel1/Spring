package org.example.demo.Controller;

import org.example.demo.Repository.Student;
import org.example.demo.Services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }



    @GetMapping("/{login}")
    public Student getAuthStudent(@PathVariable String login, @RequestParam String password) {
        return studentService.authenticate(login, password);
    }

    @PostMapping()
    public Student create(@RequestBody Student student) {
        return studentService.Create(student);
    }

    @DeleteMapping
    public void delete(@RequestParam String login, @RequestParam String password) {
        studentService.Delete(login, password);
    }

    @PutMapping()
    public void update(@RequestBody Student student, @RequestParam String login, @RequestParam String password) {
        studentService.update(login, password, student);
    }
}
