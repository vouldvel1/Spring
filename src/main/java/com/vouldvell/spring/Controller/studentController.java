package com.vouldvell.spring.Controller;

import com.vouldvell.spring.Model.Student;
import com.vouldvell.spring.service.StudentService;
import com.vouldvell.spring.service.impl.InMemoryStudentServiceImpl;
import org.springframework.web.bind.annotation.*;
import repository.InMemoryStudentDAO;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/students")
public class studentController {

     private final StudentService service = new InMemoryStudentServiceImpl(new InMemoryStudentDAO());

     @GetMapping
     public List<Student> FindAllStudents(){
          return service.FindAllStudents();
     }

     @PostMapping("Create")
     public Student CreateAccount(@RequestBody Student student){
        return service.CreateAccount(student);
     }

     @PostMapping("set/{login}:{password}")
     public Student SetInfoStudent(@PathVariable String login, @PathVariable String password, @RequestBody Student student){
          return service.SetInfoStudent(login, password, student);
     }

     @GetMapping("/{email}")
     public Student FindByEmail(@PathVariable String email){
          return service.findByEmail(email);
     }

     @GetMapping("GetID/{id}")
     public Student FindByID(@PathVariable("id") int id){
          return service.findByID(id);
     }

     @PutMapping("UpdateStudent")
     public Student UpdateStudent(@RequestBody Student student){
          return service.updateStudent(student);
     }

     @DeleteMapping("DeleteStudent/{id}")
     public void DeleteStudent(@PathVariable int id){
          service.deleteStudent(id);
     }
}
