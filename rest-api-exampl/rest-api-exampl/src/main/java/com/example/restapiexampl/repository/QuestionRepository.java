package com.example.restapiexampl.repository;

import com.example.restapiexampl.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
