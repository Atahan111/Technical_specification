package com.example.restapiexampl.dto;

import lombok.Data;

@Data
public class UserAnswerCheckDto {

    private Long userId;

    private Long questionnaireId;

}
