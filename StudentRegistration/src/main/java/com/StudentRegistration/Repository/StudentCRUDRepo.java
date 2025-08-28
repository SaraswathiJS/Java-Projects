package com.StudentRegistration.Repository;

import com.StudentRegistration.Bean.StudentBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCRUDRepo extends JpaRepository<StudentBean,Integer> {
}
