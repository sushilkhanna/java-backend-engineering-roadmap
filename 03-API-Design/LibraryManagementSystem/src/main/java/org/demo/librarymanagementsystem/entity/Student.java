package org.demo.librarymanagementsystem.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<IssuedBook> issuedbook;

    public Student() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IssuedBook> getIssuedbook() {
        return issuedbook;
    }

    public void setIssuedbook(List<IssuedBook> issuedbook) {
        this.issuedbook = issuedbook;
    }
}
