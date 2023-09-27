package com.example.restapiexampl.service;

import com.example.restapiexampl.dto.QuestionnaireRequestDto;
import com.example.restapiexampl.dto.QuestionnaireUpdateRequestDto;
import com.example.restapiexampl.entity.Questionnaire;
import com.example.restapiexampl.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {
    @Autowired
    QuestionnaireRepository questionnaireRepository;

    public void creatQuestioonaire(QuestionnaireRequestDto requestDto){
       Questionnaire questionnare = new Questionnaire();

       questionnare.setName(requestDto.getName());
       questionnare.setQuestionnaireType(requestDto.getQuestionnaireType());
       questionnaireRepository.save(questionnare);

    }

    public List<Questionnaire> getAll(){
        return questionnaireRepository.findAll();
    }

    public Questionnaire findById(Long id)throws Exception{
            return questionnaireRepository.findById(id).orElseThrow(
                    ()->new Exception("Questionnaire not found Id" + id)
            );
    }

    public void update (QuestionnaireUpdateRequestDto questionnaireRequestDto)throws Exception{
        Questionnaire questionnaire = questionnaireRepository.findById(questionnaireRequestDto
                .getId()).orElseThrow(()-> new Exception("questioonaire  not found id = " + questionnaireRequestDto.getId()));
        questionnaire.setName(questionnaireRequestDto.getName());
        questionnaire.setQuestionnaireType(questionnaireRequestDto.getQuestionnaireType());
        questionnaireRepository.save(questionnaire);
    }

    public void delete(Long questionnaireId){
        questionnaireRepository.deleteById(questionnaireId);

    }

}
