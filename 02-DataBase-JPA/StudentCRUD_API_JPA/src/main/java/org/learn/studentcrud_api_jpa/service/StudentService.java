package org.learn.studentcrud_api_jpa.service;

import org.learn.studentcrud_api_jpa.model.StudentData;
import org.learn.studentcrud_api_jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;

    public List<StudentData> readAll(){
        return repo.findAll();
    }

    public StudentData readById(int id){
        return repo.findById(id).orElse(null);
    }

    public StudentData create(StudentData studentData){
        return repo.save(studentData);
    }

    public StudentData update(StudentData studentData){
        return repo.save(studentData);
    }

    public void deleteById(int id){
        repo.deleteById(id);
    }
}
