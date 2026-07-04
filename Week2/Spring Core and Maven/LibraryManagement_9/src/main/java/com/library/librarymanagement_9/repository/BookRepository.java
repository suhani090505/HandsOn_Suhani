package com.library.librarymanagement_9.repository;

import com.library.librarymanagement_9.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}