package com.epam.cdp.spring.mvc.controller.validator;

import com.epam.cdp.hibernate.model.User;
import com.epam.cdp.spring.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Ilya_Kukushkin on 2/23/2015
 */
public class UserLoginValidator implements Validator {

    private static final int MINIMUM_PASSWORD_LENGTH = 6;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User login = (User) target;
        if (login.getPassword() != null
                && login.getPassword().trim().length() < MINIMUM_PASSWORD_LENGTH) {
            errors.rejectValue("password", "field.min.length",
                    new Object[]{Integer.valueOf(MINIMUM_PASSWORD_LENGTH)},
                    "The password must be at least [" + MINIMUM_PASSWORD_LENGTH + "] characters in length.");
        }
    }
}
