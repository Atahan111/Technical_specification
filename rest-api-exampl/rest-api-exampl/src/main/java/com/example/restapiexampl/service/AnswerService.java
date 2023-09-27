package com.example.restapiexampl.service;

import com.example.restapiexampl.dto.AnswerRequestDto;
import com.example.restapiexampl.dto.AnswerUpdateDto;
import com.example.restapiexampl.entity.Answer;
import com.example.restapiexampl.entity.Question;
import com.example.restapiexampl.repository.AnswerRepository;
import com.example.restapiexampl.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public void creat(AnswerRequestDto answerRequestDto)throws Exception{
        Answer answer = new Answer();
        answer.setAnswer(answerRequestDto.getAnswer());

        Question question = questionRepository.findById(answerRequestDto.getQuestionId())
                .orElseThrow(()->new Exception("not found by ID "+ answerRequestDto.getQuestionId()));

        answer.setQuestion(question);
        answerRepository.save(answer);
    }

    public List<Answer> getAll(){
        return  answerRepository.findAll();
    }

    public void update(AnswerUpdateDto answerUpdateDto)throws Exception{
        Answer answer = answerRepository.findById(answerUpdateDto.getId())
                .orElseThrow(()->new Exception("not found by id " + answerUpdateDto.getId()));
        Question question = questionRepository.findById(answerUpdateDto.getQuestionId())
                .orElseThrow(()->new Exception("not found by ID "+ answerUpdateDto.getQuestionId()));

        answer.setQuestion(question);
        answerRepository.save(answer);

    }
    public void delete(Long id){
      answerRepository.deleteById(id);
    }
}
