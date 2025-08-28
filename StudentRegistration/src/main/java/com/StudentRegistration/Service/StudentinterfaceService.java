package com.StudentRegistration.Service;

import com.StudentRegistration.Bean.StudentBean;

import java.util.List;

public interface StudentinterfaceService {
    StudentBean getStudent(int sid);

    List<StudentBean> getStudentList();

    StudentBean insertStudent(StudentBean student);

    void insertMultiple(List<StudentBean> studentList);

    StudentBean editStudent(int sid, StudentBean student);

    String deleteStudent(int sid);
}
