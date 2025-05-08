package com.onndoo.book.jakarta10.recipes.chapter3.controller;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;


import java.util.Set;

@FacesValidator("employeeTitleValidator")
public class EmployeeTitleValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value)
            throws ValidatorException {
        checkTitle(value);
    }

    private void checkTitle(Object value) {
        String title = value.toString();
        if (!title.contains("Java")) {
            String messageText = "Title does not include the word Java";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    messageText, messageText));
        }
    }

}