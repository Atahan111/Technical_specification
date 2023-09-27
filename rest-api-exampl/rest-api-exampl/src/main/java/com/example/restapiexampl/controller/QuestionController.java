package com.example.restapiexampl.controller;

import com.example.restapiexampl.dto.QuestionRequestDto;
import com.example.restapiexampl.dto.QuestionUpdateDto;
import com.example.restapiexampl.entity.Question;
import com.example.restapiexampl.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/create")
    public void create(@RequestBody QuestionRequestDto questionRequestDto) throws Exception {
        questionService.create(questionRequestDto);
    }

    @GetMapping("/get-all")
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @PutMapping("/update")
    public void update(@RequestBody QuestionUpdateDto questionUpdateDto) throws Exception {
        questionService.update(questionUpdateDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        questionService.delete(id);
    }

}
