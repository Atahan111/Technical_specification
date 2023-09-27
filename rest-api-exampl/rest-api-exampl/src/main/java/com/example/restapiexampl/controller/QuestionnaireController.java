package com.example.restapiexampl.controller;

import com.example.restapiexampl.dto.QuestionnaireRequestDto;
import com.example.restapiexampl.dto.QuestionnaireUpdateRequestDto;
import com.example.restapiexampl.entity.Question;
import com.example.restapiexampl.entity.Questionnaire;
import com.example.restapiexampl.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @PostMapping("/create")
    private void create(@RequestBody QuestionnaireRequestDto requestDto){
        questionnaireService.creatQuestioonaire(requestDto);

    }
    @GetMapping("/get-All")
    private List<Questionnaire> getAll(){
        return questionnaireService.getAll();
    }
    @GetMapping("/find-by-id/{questionnaireId}")
    private Questionnaire findById(@PathVariable long questionnaireId)throws Exception{
        return questionnaireService.findById(questionnaireId);
    }

    @PutMapping("/update")
    private  void  uddate(@RequestBody QuestionnaireUpdateRequestDto questionnaireRequestDto)throws Exception{
        questionnaireService.update(questionnaireRequestDto);
    }

    @DeleteMapping("/delete")
    private void delete(@RequestParam Long questionnaireId){
        questionnaireService.delete(questionnaireId);
    }


}
