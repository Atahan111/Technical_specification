package com.example.restapiexampl.repository;

import com.example.restapiexampl.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
