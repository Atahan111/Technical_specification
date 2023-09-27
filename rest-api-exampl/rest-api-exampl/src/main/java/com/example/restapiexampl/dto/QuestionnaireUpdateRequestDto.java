package com.example.restapiexampl.dto;

import com.example.restapiexampl.enums.QuestionnaireType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionnaireUpdateRequestDto {
    private Long id;
    private String name;
    QuestionnaireType questionnaireType;
}
