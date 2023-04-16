package cz.mka.quotation.service;

import cz.mka.quotation.model.Customer;

public interface CustomerService {

    Customer updateCustomer(Customer customer, Long id);
}
