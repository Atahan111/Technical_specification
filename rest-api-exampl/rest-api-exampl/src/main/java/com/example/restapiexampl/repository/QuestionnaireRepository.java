package com.example.restapiexampl.repository;

import com.example.restapiexampl.entity.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {

}
