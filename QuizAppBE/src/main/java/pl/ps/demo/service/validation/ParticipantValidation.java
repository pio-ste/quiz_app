package pl.ps.demo.service.validation;

import pl.ps.demo.exception.ValidationException;
import pl.ps.demo.service.dto.ParticipantDTO;

import java.util.List;

import static pl.ps.demo.service.validation.ArgumentValidation.*;

public class ParticipantValidation {

    private List<String> exceptionList;
    private final ParticipantDTO participantDTO;

    public ParticipantValidation(List<String> exceptionList, ParticipantDTO participantDTO) {
        this.exceptionList = exceptionList;
        this.participantDTO = participantDTO;
    }

    public void validate(){

        if (isNull(participantDTO.getResult())){
            exceptionList.add("Wyniki nie może być pusty!");
        } else if (minValue(participantDTO.getResult(), 1)){
            exceptionList.add("Minimalna liczba punktów wynosi 1!");
        } else if (maxValue(participantDTO.getResult(), 999)){
            exceptionList.add("Maksymalna liczba punktów może wynosić 999!");
        }

        if(isNull(participantDTO.getStatus())){
            exceptionList.add("Brak statusu ukończenia Quiz'u!");
        }

        if (!exceptionList.isEmpty()) throw new ValidationException(exceptionList);
    }
}
