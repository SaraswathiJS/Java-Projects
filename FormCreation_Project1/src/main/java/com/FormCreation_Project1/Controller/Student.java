package com.FormCreation_Project1.Controller;

import com.FormCreation_Project1.Bean.StudentBean;
import com.FormCreation_Project1.Bean.StudentDetail;
import com.FormCreation_Project1.Repository.StudentCRUDRepository;
import com.FormCreation_Project1.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller

@RequestMapping("/students")
public class Student {
    @Autowired
    private StudentCRUDRepository studentCRUDRepository;
    @Autowired
    private StudentService studentService;


    @GetMapping({"","/"})
    public String getstudents(Model model){
      var students =  studentCRUDRepository.findAll();
      model.addAttribute("students",students);
        return "students/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        StudentDetail studentDetail = new StudentDetail();
        model.addAttribute("studentDetail",studentDetail);
        return "students/create";
    }
    @PostMapping("/create")

    public String getStudent(@ModelAttribute StudentDetail studentDetail) {

        StudentBean studentBean = new StudentBean();
        studentBean.setFullName(studentDetail.getFullName());
        studentBean.setEmail(studentDetail.getEmail());
        studentBean.setAddress(studentDetail.getAddress());
        studentBean.setPhoneNumber(studentDetail.getPhoneNumber());
       studentBean.setGender(studentDetail.getGender());
       studentBean.setCourseName(studentDetail.getCourseName());
       studentBean.setPassword(studentDetail.getPassword());
       studentBean.setDob(LocalDate.parse(studentDetail.getDob().toString()));

        studentCRUDRepository.save(studentBean);
        return "redirect:/students";
    }
    @GetMapping("/edit")
    public String edit(Model model,@RequestParam int id){
        StudentDetail studentDetail = new StudentDetail();
       StudentBean studentBean = studentCRUDRepository.findById(id).orElse(null);
        if (studentBean == null) {
            return "redirect:/students"; // student not found
        }


        StudentDetail studentDetail1 = new StudentDetail();
       studentDetail1.setFullName(studentBean.getFullName());
       studentDetail1.setEmail(studentBean.getEmail());
       studentDetail1.setAddress(studentBean.getAddress());
       studentDetail1.setPhoneNumber(studentBean.getPhoneNumber());
       studentDetail1.setGender(studentBean.getGender());
       studentDetail1.setCourseName(studentBean.getCourseName());
       studentDetail1.setPassword(studentBean.getPassword());
       studentDetail1.setDob(studentBean.getDob());
       model.addAttribute("studentDetail",studentDetail1);
       model.addAttribute("studentBean",studentBean);
       return "students/edit";

    }

    @PostMapping("/edit")
    public String editStudent(@Valid @ModelAttribute StudentDetail studentDetail,
                              @RequestParam int id,
                              Model model,
                              BindingResult bindingResult) {

        // 1. Validate input
        if (bindingResult.hasErrors()) {
            return "students/edit"; // back to edit form
        }

        // 2. Fetch existing student from DB
        StudentBean studentBean = studentCRUDRepository.findById(id).orElse(null);

        if (studentBean == null) {
            // If not found, redirect to list page
            return "redirect:/students";
        }

        // 3. Update fields
        studentBean.setFullName(studentDetail.getFullName());
        studentBean.setEmail(studentDetail.getEmail());
        studentBean.setAddress(studentDetail.getAddress());
        studentBean.setPhoneNumber(studentDetail.getPhoneNumber());
        studentBean.setGender(studentDetail.getGender());
        studentBean.setCourseName(studentDetail.getCourseName());
        studentBean.setPassword(studentDetail.getPassword());
        studentBean.setDob(LocalDate.parse(studentDetail.getDob().toString())); // assuming it's already a LocalDate

        // 4. Save updated student
        studentCRUDRepository.save(studentBean);

        // 5. Redirect to list
        return "redirect:/students";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id){

        StudentBean studentBean = studentCRUDRepository.findById(id).orElse(null);
        if (studentBean != null) {
            studentCRUDRepository.delete(studentBean);
        }
            return "redirect:/students"; // student not found
        }

}
