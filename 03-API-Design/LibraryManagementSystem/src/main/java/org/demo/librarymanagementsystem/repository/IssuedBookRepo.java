package org.demo.librarymanagementsystem.repository;

import org.demo.librarymanagementsystem.entity.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuedBookRepo extends JpaRepository<IssuedBook,Integer> {
}
