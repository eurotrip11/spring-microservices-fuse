package it.youbnb.microservices.customer.controllers;

import it.youbnb.microservices.customer.exceptions.CustomerAlreadyExistsException;
import it.youbnb.microservices.customer.model.Customer;
import it.youbnb.microservices.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Customer register(@RequestBody @Valid Customer customer) throws CustomerAlreadyExistsException {
        Collection<Customer> customers = customerRepository.findByEmail(customer.getEmail());
        if (customers.size() > 0){
            throw new CustomerAlreadyExistsException();
        }
        return customerRepository.save(customer);
    }
}
