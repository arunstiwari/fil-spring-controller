package com.fil.springcontroller.repository;


import com.fil.springcontroller.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
