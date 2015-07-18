package it.youbnb.microservices.customer.controllers.advice;

import it.youbnb.microservices.customer.exceptions.CustomerAlreadyExistsException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@ControllerAdvice
@RequestMapping(produces = "application/vnd.error")
@ResponseBody
public class CustomerControllerAdvice {

    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public VndErrors customerAlreadyExistsException(CustomerAlreadyExistsException e) {
        return this.error(e, e.getMessage());
    }

    private <E extends Exception> VndErrors error(E e, String logref) {
        String msg = Optional.of(e.getMessage()).orElse(e.getClass().getSimpleName());
        return new VndErrors(logref, msg);
    }
}
