package com.jayklef.bla.repository;

import com.jayklef.bla.model.Book;
import com.jayklef.bla.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
