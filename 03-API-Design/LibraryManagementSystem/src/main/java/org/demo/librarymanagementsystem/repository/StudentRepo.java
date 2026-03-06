package org.demo.librarymanagementsystem.repository;

import org.demo.librarymanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
