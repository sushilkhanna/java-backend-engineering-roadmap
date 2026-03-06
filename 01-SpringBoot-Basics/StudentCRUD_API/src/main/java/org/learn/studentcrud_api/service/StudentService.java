package org.learn.studentcrud_api.service;

import org.learn.studentcrud_api.model.StudentData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<StudentData> students = new ArrayList<>();
    public List<StudentData> readAll(){
        return students;
    }
    public StudentData readById(int id){
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public StudentData addData(StudentData student){
        students.add(student);
        return student;
    }
    public StudentData updateData(int id, StudentData student){
        for(StudentData s : students){
            if(s.getId()==id){
                s.setName(student.getName());
                s.setAge(student.getAge());
                return s;
            }
        }
        return null;
    }
    public String deleteData(int id){
        students.removeIf(s->s.getId()==id);
        return "Data is deleted of id: " +id;
    }
}
