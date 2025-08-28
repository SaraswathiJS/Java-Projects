package com.FormCreation_Project1.Repository;

import com.FormCreation_Project1.Bean.StudentBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCRUDRepository extends JpaRepository<StudentBean, Integer> {
}
