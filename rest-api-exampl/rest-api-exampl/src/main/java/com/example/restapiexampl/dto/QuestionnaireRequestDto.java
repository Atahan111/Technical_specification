package com.example.restapiexampl.dto;

import com.example.restapiexampl.enums.QuestionnaireType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionnaireRequestDto {

    private String name;

    QuestionnaireType questionnaireType;
}
