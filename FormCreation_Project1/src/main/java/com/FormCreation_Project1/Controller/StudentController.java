package com.FormCreation_Project1.Controller;

import com.FormCreation_Project1.Bean.StudentBean;
import com.FormCreation_Project1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
