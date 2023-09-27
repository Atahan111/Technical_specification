package com.example.restapiexampl.repository;

import com.example.restapiexampl.entity.UserQuestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuestionnaireRepository extends JpaRepository<UserQuestionnaire, Long> {

    UserQuestionnaire findByUser_IdAndQuestionnaire_Id(Long userId, Long questionnaireId);

}
