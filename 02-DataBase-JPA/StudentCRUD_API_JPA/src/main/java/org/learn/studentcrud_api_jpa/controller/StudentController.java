package org.learn.studentcrud_api_jpa.controller;

import org.learn.studentcrud_api_jpa.model.StudentData;
import org.learn.studentcrud_api_jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/test")
    public String test(){
        return "working";
    }

    @GetMapping("/readAll")
    public List<StudentData> readAll(){
        return studentService.readAll();
    }

    @GetMapping("/{id}")
    public StudentData readById(@PathVariable int id){
        return studentService.readById(id);
    }

    @PostMapping
    public StudentData create(@RequestBody StudentData studentData){
        return studentService.create(studentData);
    }

    @PutMapping
    public StudentData update(@RequestBody StudentData studentData){
        return studentService.update(studentData);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.deleteById(id);
    }
}
