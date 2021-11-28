package pl.ps.demo.service.validation;

import pl.ps.demo.exception.ValidationException;
import pl.ps.demo.service.dto.UserAnswerDTO;

import java.util.List;

import static pl.ps.demo.service.validation.ArgumentValidation.*;

public class UserAnswerValidation {

    private List<String> exceptionList;
    private final UserAnswerDTO userAnswerDTO;

    public UserAnswerValidation(List<String> exceptionList, UserAnswerDTO userAnswerDTO) {
        this.exceptionList = exceptionList;
        this.userAnswerDTO = userAnswerDTO;
    }

    public void validate(){
        if (isNull(userAnswerDTO.getCorrect())){
            exceptionList.add("Wybierz odpowiedź!");
        }

        if (!exceptionList.isEmpty()) throw new ValidationException(exceptionList);
    }
}
