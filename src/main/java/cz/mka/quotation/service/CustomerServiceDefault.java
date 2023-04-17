package cz.mka.quotation.service;

import cz.mka.quotation.model.Customer;
import cz.mka.quotation.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceDefault implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer updateCustomer(Customer customer, Long id) {

        Customer c = customerRepository.getReferenceById(id);
        try {
            c.setFirstName(customer.getFirstName());
        } catch (EntityNotFoundException e) {
            return null;
        }
        c.setLastName(customer.getLastName());
        c.setMiddleName(customer.getMiddleName());
        c.setBirthDate(customer.getBirthDate());
        c.setEmail(customer.getEmail());
        c.setPhoneNumber(customer.getPhoneNumber());

        return customerRepository.save(c);
    }

}
