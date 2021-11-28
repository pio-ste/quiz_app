package pl.ps.demo.service.validation;

import pl.ps.demo.exception.ValidationException;
import pl.ps.demo.service.dto.UserDTO;

import java.util.List;

import static pl.ps.demo.service.validation.ArgumentValidation.*;

public class UserValidation {

    private List<String> exceptionList;
    private final UserDTO userDTO;

    public UserValidation(List<String> exceptionList, UserDTO userDTO) {
        this.exceptionList = exceptionList;
        this.userDTO = userDTO;
    }

    public void validate(){
        if (isNull(userDTO.getUserName()) || isEmpty(userDTO.getUserName())){
            exceptionList.add("Wpisz nazwę użytkownika!");
        } else if (minLength(userDTO.getUserName(), 4)){
            exceptionList.add("Nazwa użytkownika musi mieć minimum 4 znaki!");
        } else if (maxLength(userDTO.getUserName(), 25)){
            exceptionList.add("Nazwa użytkownika musi mieć maksymalnie 25 znaków!");
        }

        if (isNull(userDTO.getPassword()) || isEmpty(userDTO.getPassword())){
            exceptionList.add("Wpisz hasło!");
        } else if (minLength(userDTO.getPassword(), 4)){
            exceptionList.add("Hasło musi mieć minimum 4 znaki!");
        } else if (maxLength(userDTO.getPassword(), 40)){
            exceptionList.add("Hasło może mieć maksymalnie 40 znaków!");
        }

        if (isNull(userDTO.getFirstName()) || isEmpty(userDTO.getFirstName())){
            exceptionList.add("Wpisz imię!");
        } else if (minLength(userDTO.getFirstName(), 2)){
            exceptionList.add("Imię musi mieć minimum 2 znaki!");
        } else if (maxLength(userDTO.getFirstName(), 40)){
            exceptionList.add("Imię może mieć maksymalnie 40 znaków!");
        }

        if (isNull(userDTO.getLastName()) || isEmpty(userDTO.getLastName())){
            exceptionList.add("Wpisz nazwisko!");
        } else if (minLength(userDTO.getLastName(), 2)){
            exceptionList.add("Nazwisko musi mieć minimum 2 znaki!");
        } else if (maxLength(userDTO.getLastName(), 40)){
            exceptionList.add("Nazwisko może mieć maksymalnie 40 znaków!");
        }


        if(isNull(userDTO.getEmail()) || isEmpty(userDTO.getEmail())){
            exceptionList.add("Wpisz email!");
        } else{
            if (!isEmail(userDTO.getEmail())){
                exceptionList.add("Podany email nie jest błędny!");
            }
            if (minLength(userDTO.getEmail(), 5)){
                exceptionList.add("Email musi mieć minimum 5 znaków!");
            } else if (maxLength(userDTO.getEmail(), 40)){
                exceptionList.add("Email może mieć maksymalnie 40 znaków!");
            }
        }

        if (!exceptionList.isEmpty()) throw new ValidationException(exceptionList);
    }
}
