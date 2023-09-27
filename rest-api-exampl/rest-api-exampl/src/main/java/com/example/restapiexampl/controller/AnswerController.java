package com.example.restapiexampl.controller;

import com.example.restapiexampl.dto.AnswerRequestDto;
import com.example.restapiexampl.dto.AnswerUpdateDto;
import com.example.restapiexampl.entity.Answer;
import com.example.restapiexampl.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping("/creat")
    public void creat(@RequestBody AnswerRequestDto answerRequestDto)throws Exception{
        answerService.creat(answerRequestDto);
    }
    @GetMapping("/get-all")
    public List<Answer> getAll(){
        return answerService.getAll();
    }

    @PutMapping("/update")
    public  void update(@PathVariable AnswerUpdateDto answerUpdateDto)throws Exception{
        answerService.update(answerUpdateDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        answerService.delete(id);
    }

}
