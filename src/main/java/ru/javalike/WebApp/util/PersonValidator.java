package ru.javalike.WebApp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.javalike.WebApp.models.Person;
import ru.javalike.WebApp.services.PersonDetailsService;

@Component
public class PersonValidator implements Validator {

    private final PersonDetailsService personDetailsService;

    @Autowired
    public PersonValidator(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        try {
            personDetailsService.loadUserByUsername(person.getUsername()); // Потом исправить код зависит от detailService
        } catch (UsernameNotFoundException ignored) {
            return; //пользователь найден
        }

        errors.rejectValue("username","","Человек с таким именем уже существует");
    }
}
