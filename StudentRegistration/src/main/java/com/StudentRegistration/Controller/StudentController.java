package com.StudentRegistration.Controller;

import com.StudentRegistration.Bean.StudentBean;
import com.StudentRegistration.Service.StudentinterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentinterfaceService studentinterfaceService;

    @GetMapping("/getstudent/{id}")
    public StudentBean getStudent(@PathVariable ("id") int sid){
        return studentinterfaceService.getStudent(sid);
    }
    // get all database details
    @GetMapping("/getstudentlist")
    public List<StudentBean> getStudentList(){
        return studentinterfaceService.getStudentList();
    }
    //insert value
    @PostMapping("/insertstudent")
    public StudentBean insertStudent(@RequestBody StudentBean student){
        return studentinterfaceService.insertStudent(student);
    }
    //insert multiple student details
    @PostMapping("/insertMultiple")
    public void insertMultiple(@RequestBody List<StudentBean> studentList){
        studentinterfaceService.insertMultiple(studentList);
    }
    //Edit value
    @PutMapping("/edit/{id}")
    public StudentBean editStudent(@PathVariable ("id") int sid, @RequestBody StudentBean student){
        student.setId(sid);
     return studentinterfaceService.editStudent(sid,student);
    }
    //delete
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable ("id") int sid){
        return studentinterfaceService.deleteStudent(sid);
    }
}
