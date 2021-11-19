package pl.ps.demo.service.validator;

import org.springframework.util.Assert;
import pl.ps.demo.service.UserService;

import static org.springframework.util.Assert.*;

public class Validator {

    public void validate(Long id) {
        notNull(id, "Id is null");
    }

    public void walidujemySobie(UserService userService, String userName) {
        userService.getUser(userName);
    }

}
