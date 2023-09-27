package com.example.restapiexampl.dto;

import com.example.restapiexampl.entity.Questionnaire;
import lombok.Data;

@Data
public class UserQuetionnaireRequestDto {
    private Long questionnaireId;
    private Long userId;
    private Long AnswerId;

}
