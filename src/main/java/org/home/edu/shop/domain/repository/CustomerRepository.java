package org.home.edu.shop.domain.repository;

import org.home.edu.shop.domain.Customer;

import java.util.List;

/**
 * Created by SweetHome on 03.06.2017.
 */

public interface CustomerRepository {

    List<Customer> getAllCustomers();

    void addCustomer(Customer customer);
}
