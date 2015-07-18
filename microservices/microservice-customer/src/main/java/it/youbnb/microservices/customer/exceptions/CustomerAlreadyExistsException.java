package it.youbnb.microservices.customer.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException() {
        super("Customer already exists!");
    }
}
