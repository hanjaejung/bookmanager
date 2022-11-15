package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Author;
import com.example.bookmanager.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
