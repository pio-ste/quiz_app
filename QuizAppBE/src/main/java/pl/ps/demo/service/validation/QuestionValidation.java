package pl.ps.demo.service.validation;

import pl.ps.demo.exception.ValidationException;
import pl.ps.demo.service.dto.QuestionDTO;

import java.util.List;

import static pl.ps.demo.service.validation.ArgumentValidation.*;

public class QuestionValidation {

    private List<String> exceptionList;
    private final QuestionDTO questionDTO;

    public QuestionValidation(List<String> exceptionList, QuestionDTO questionDTO) {
        this.exceptionList = exceptionList;
        this.questionDTO = questionDTO;
    }

    public void validate(){
        if (isNull(questionDTO.getContent()) || isEmpty(questionDTO.getContent())){
            exceptionList.add("Wpisz zawartość pytania!");
        } else if (minLength(questionDTO.getContent(), 4)){
            exceptionList.add("Pytanie musi mieć minimum 4 znaki!");
        } else if (maxLength(questionDTO.getContent(), 50)){
            exceptionList.add("Pytanie musi mieć maksymalnie 50 znaków!");
        }

        if (isNull(questionDTO.getTime())){
            exceptionList.add("Wpisz czas (s) na odpowiedź!");
        } else if (minValue(questionDTO.getTime(), 10)){
            exceptionList.add("Minimalny czas na odpowiedź wynosi 10 sekund!");
        } else if (maxValue(questionDTO.getTime(), 300)){
            exceptionList.add("Maksymalny czas na odpowiedź wynosi 300 sekund!");
        }

        if (isNull(questionDTO.getPoints())){
            exceptionList.add("Wpisz maksymalną liczbę punktów!");
        } else if (minValue(questionDTO.getPoints(), 1)){
            exceptionList.add("Minimalna liczba punktów wynosi 1!");
        } else if (maxValue(questionDTO.getPoints(), 999)){
            exceptionList.add("Maksymalna liczba punktów może wynosić 999!");
        }

        if (!exceptionList.isEmpty()) throw new ValidationException(exceptionList);
    }
}
