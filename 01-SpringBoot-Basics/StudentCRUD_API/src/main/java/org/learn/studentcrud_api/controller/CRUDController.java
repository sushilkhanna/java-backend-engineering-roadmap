package org.learn.studentcrud_api.controller;

import org.learn.studentcrud_api.model.StudentData;
import org.springframework.web.bind.annotation.*;
import org.learn.studentcrud_api.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class CRUDController {

    private final StudentService service;
    public CRUDController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/readAll")
    public List<StudentData> readAll(){
        return service.readAll();
    }
    @GetMapping("/{id}")
    public StudentData readById(@PathVariable int id){
        return service.readById(id);
    }

    @PostMapping
    public StudentData addData(@RequestBody StudentData student){
        return service.addData(student);
    }

    @PutMapping("/{id}")
    public StudentData updateData(@PathVariable int id, @RequestBody StudentData student){
        return service.updateData(id, student);
    }
    @DeleteMapping("/{id}")
    public String deleteData(@PathVariable int id){
        return service.deleteData(id);
    }
}
