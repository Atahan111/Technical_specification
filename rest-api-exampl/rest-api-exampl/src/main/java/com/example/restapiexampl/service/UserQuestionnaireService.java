package com.example.restapiexampl.service;

import com.example.restapiexampl.dto.UserAnswerCheckDto;
import com.example.restapiexampl.dto.UserQuetionnaireRequestDto;
import com.example.restapiexampl.dto.UserUpdateRequestDto;
import com.example.restapiexampl.entity.*;
import com.example.restapiexampl.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuestionnaireService {
    @Autowired
    private UserQuestionnaireRepository userQuestionnaireRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;


    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Autowired
    private AnswerRepository answerRepository;


    public void create(UserQuetionnaireRequestDto userQuetionnaireRequestDto) {
        //создать UserQuEntity
        //Получить все entity из userUpdateRequestDto
        //Засетить эти entity в userQuEntity
        //Сохранить
        //Вернуть из метода

        UserQuestionnaire userQuestionnaire = new UserQuestionnaire();


        User user = userRepository.findById(userQuetionnaireRequestDto.getUserId()).orElseThrow();

        userQuestionnaire.setUser(user);


        Questionnaire questionnaire = questionnaireRepository.findById(userQuetionnaireRequestDto.getQuestionnaireId()).orElseThrow();

        userQuestionnaire.setQuestionnaire(questionnaire);


        Answer answer = answerRepository.findById(userQuetionnaireRequestDto.getAnswerId()).orElseThrow();

        userQuestionnaire.setAnswer(answer);

        userQuestionnaireRepository.save(userQuestionnaire);


    }
    public List<UserQuestionnaire> getAll(){
        return userQuestionnaireRepository.findAll();
    }


    public UserQuestionnaire checkAnswer(UserAnswerCheckDto userAnswerCheckDto){

        return userQuestionnaireRepository.findByUser_IdAndQuestionnaire_Id(userAnswerCheckDto.getUserId(), userAnswerCheckDto.getQuestionnaireId());
    }

}
