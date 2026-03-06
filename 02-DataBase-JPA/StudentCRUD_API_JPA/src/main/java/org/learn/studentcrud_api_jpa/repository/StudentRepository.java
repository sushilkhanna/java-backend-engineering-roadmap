package org.learn.studentcrud_api_jpa.repository;

import org.learn.studentcrud_api_jpa.model.StudentData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentData, Integer> {
}
