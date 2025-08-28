package com.FormCreation_Project1.Service;

import com.FormCreation_Project1.Bean.StudentBean;
import com.FormCreation_Project1.Repository.StudentCRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImple implements StudentService {

    @Autowired
    private StudentCRUDRepository  studentCRUDRepository;



}
