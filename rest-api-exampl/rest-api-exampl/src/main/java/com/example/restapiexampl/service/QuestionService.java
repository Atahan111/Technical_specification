package com.example.restapiexampl.service;

import com.example.restapiexampl.dto.QuestionRequestDto;
import com.example.restapiexampl.dto.QuestionUpdateDto;
import com.example.restapiexampl.entity.Question;
import com.example.restapiexampl.entity.Questionnaire;
import com.example.restapiexampl.repository.QuestionRepository;
import com.example.restapiexampl.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public QuestionService() {
    }

    public void create(QuestionRequestDto questionRequestDto) throws Exception {
        Question question = new Question();
        question.setQuestion(questionRequestDto.getQuestion());

        Questionnaire questionnaire = questionnaireRepository.findById(questionRequestDto.getQuestionnaireId())
                .orElseThrow(() -> new Exception("not by " + questionRequestDto.getQuestionnaireId()));

        question.setQuestionnaire(questionnaire);
        questionRepository.save(question);
    }

    public List<Question> getAll(){
        return questionRepository.findAll();
    }

    public void update(QuestionUpdateDto questionUpdateDto) throws Exception {
        Question question = questionRepository.findById(questionUpdateDto.getId())
                .orElseThrow(()-> new Exception("not found by id " +  questionUpdateDto.getId()));
        question.setQuestion(questionUpdateDto.getQuestion());
        Questionnaire questionnaire = questionnaireRepository.findById(questionUpdateDto.getQuestionnaireId())
                .orElseThrow(() -> new Exception("" + questionUpdateDto.getQuestionnaireId()));

        question.setQuestionnaire(questionnaire);
        questionRepository.save(question);
    }

    public void delete(Long id){
        questionnaireRepository.deleteById(id);
    }

}
