package com.StudentRegistration.Service;

import com.StudentRegistration.Bean.StudentBean;
import com.StudentRegistration.Repository.StudentCRUDRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentinterfaceService {

    @Autowired
    private StudentCRUDRepo studentCRUDRepo;

    @Override
    public StudentBean getStudent(int sid) {
        return studentCRUDRepo.findById(sid).get();
    }

    @Override
    public List<StudentBean> getStudentList() {
        return studentCRUDRepo.findAll();
    }
    //insertmethod
    @Override
    public StudentBean insertStudent(StudentBean student) {
        return studentCRUDRepo.save(student);
    }
     //insert multiple student details
    @Override
    public void insertMultiple(List<StudentBean> studentList) {
        studentCRUDRepo.saveAll(studentList);
    }
    //edit
    @Override
    public StudentBean editStudent(int sid, StudentBean student) {
       StudentBean bean = studentCRUDRepo.findById(sid).get();
       bean.setFirstName(student.getFirstName());
       bean.setId(student.getId());
       bean.setAddress(student.getAddress());
       bean.setEmail(student.getEmail());
       bean.setCourseName(student.getCourseName());
       bean.setPhoneNumber(student.getPhoneNumber());
       bean.setPassword(student.getPassword());
       StudentBean savebean = studentCRUDRepo.save(bean);
        return savebean;
    }

    @Override
    public String deleteStudent(int sid) {
        studentCRUDRepo.deleteById(sid);
        return "deleted successfully";
    }
}
