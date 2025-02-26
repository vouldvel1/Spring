package com.vouldvell.spring.Controller;

import com.vouldvell.spring.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1/students")
public class studentController {
    private final StudentService studentService;

    public studentController(StudentService studentService) {
        this.studentService = studentService;
    }

}
