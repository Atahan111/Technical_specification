package com.example.restapiexampl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerUpdateDto {
    private Long id;

    private String answer;
    private Long questionId;
}
