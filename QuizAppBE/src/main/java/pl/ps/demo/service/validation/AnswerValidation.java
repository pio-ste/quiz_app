package pl.ps.demo.service.validation;

import pl.ps.demo.exception.ValidationException;
import pl.ps.demo.service.dto.AnswerDTO;

import java.util.List;

import static pl.ps.demo.service.validation.ArgumentValidation.*;

public class AnswerValidation {

    private List<String> exceptionList;
    private List<AnswerDTO> answerDTOS;
    public AnswerValidation(List<String> exceptionList, List<AnswerDTO> answerDTOS) {
        this.exceptionList = exceptionList;
        this.answerDTOS = answerDTOS;
    }
    public void validate(){
        answerDTOS.forEach(answerDTO -> {
            if (isNull(answerDTO.getContent()) || isEmpty(answerDTO.getContent())){
                exceptionList.add("Wpisz zawartość odpowiedzi!");
            } else if (minLength(answerDTO.getContent(), 1)){
                exceptionList.add("Odpowiedź musi mieć przynajmniej 1 znak!");
            } else if (maxLength(answerDTO.getContent(), 50)){
                exceptionList.add("Odpowiedź musi mieć maksymalnie 50 znaków!");
            }

            if (isNull(answerDTO.getCorrect())){
                exceptionList.add("Zaznacz poprawność odpowiedzi!");
            }
        });
        if (!exceptionList.isEmpty()) throw new ValidationException(exceptionList);
    }
}
