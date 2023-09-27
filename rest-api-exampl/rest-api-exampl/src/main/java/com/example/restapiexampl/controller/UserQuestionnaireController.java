package com.example.restapiexampl.controller;

import com.example.restapiexampl.dto.UserAnswerCheckDto;
import com.example.restapiexampl.dto.UserQuetionnaireRequestDto;
import com.example.restapiexampl.entity.UserQuestionnaire;
import com.example.restapiexampl.service.UserQuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userquestionnaire")
public class UserQuestionnaireController {
    @Autowired
    private UserQuestionnaireService userQuestionnaireService;

    @PostMapping("/create")
    public void create(@RequestBody UserQuetionnaireRequestDto dto) {
        userQuestionnaireService.create(dto);
    }

    @GetMapping("/get-ALl")
    public List<UserQuestionnaire> getAll(){
        return userQuestionnaireService.getAll();
    }
    @GetMapping("/check_answer")
public UserQuestionnaire checkAnswer( UserAnswerCheckDto userAnswerCheckDto){
        return userQuestionnaireService.checkAnswer(userAnswerCheckDto);
    }
}
