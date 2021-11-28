package pl.ps.demo.service.validation;

import pl.ps.demo.exception.ValidationException;
import pl.ps.demo.service.dto.QuizDTO;

import java.util.List;

import static pl.ps.demo.service.validation.ArgumentValidation.*;

public class QuizValidation {

    private List<String> exceptionList;
    private final QuizDTO quizDTO;

    public QuizValidation(List<String> exceptionList, QuizDTO quizDTO) {
        this.exceptionList = exceptionList;
        this.quizDTO = quizDTO;
    }

    public void validate(){
        if (isNull(quizDTO.getTitle()) || isEmpty(quizDTO.getTitle())){
            exceptionList.add("Wpisz tytuł Quiz'u!");
        } else if (minLength(quizDTO.getTitle(), 4)){
            exceptionList.add("Tytuł musi mieć minimum 4 znaki!");
        } else if (maxLength(quizDTO.getTitle(), 50)){
            exceptionList.add("Tytuł musi mieć maksymalnie 50 znaków!");
        }

        if (isNull(quizDTO.getDescription()) || isEmpty(quizDTO.getDescription())){
            exceptionList.add("Wpisz opis Quiz'u!");
        } else if (minLength(quizDTO.getDescription(), 4)){
            exceptionList.add("Opis musi mieć minimum 5 znaków!");
        } else if (maxLength(quizDTO.getDescription(), 200)){
            exceptionList.add("Opis musi mieć maksymalnie 200 znaków!");
        }

        if (isNull(quizDTO.getMaxPoints())){
            exceptionList.add("Wpisz maksymalną liczbę punktów!");
        } else if (minValue(quizDTO.getMaxPoints(), 1)){
            exceptionList.add("Minimalna liczba punktów wynosi 1!");
        } else if (maxValue(quizDTO.getMaxPoints(), 999)){
            exceptionList.add("Maksymalna liczba punktów może wynosić 999!");
        }

        if(isNull(quizDTO.getStartDate()) || isNull(quizDTO.getEndDate())){
            exceptionList.add("Wybierz datę rozpoczęcia i zakończenia!");
        } else{
            if (endDateIsBeforeStartDate(quizDTO.getStartDate(), quizDTO.getEndDate())){
                exceptionList.add("Data zakończenia nie może być wcześniejsza od daty rozpoczęcia!");
            }
            if (isBeforeNow(quizDTO.getStartDate())){
                exceptionList.add("Data rozpoczęcia musi być poźniejsza od aktualnej daty!");
            }
            if (isBeforeNow(quizDTO.getEndDate())){
                exceptionList.add("Data zakończenia musi być poźniejsza od aktualnej daty!");
            }
        }

        if (!exceptionList.isEmpty()) throw new ValidationException(exceptionList);
    }
}
