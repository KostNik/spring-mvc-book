package org.home.edu.shop.domain.repository.impl;

import org.home.edu.shop.domain.Customer;
import org.home.edu.shop.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SweetHome on 03.06.2017.
 */
@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getAllCustomers() {
        Map<String, Object> params = new HashMap<>();
        return jdbcTemplate.query("SELECT * FROM customers", params, new CustomerMapper());
    }

    @Override
    public void addCustomer(Customer customer) {
        String SQL = "INSERT INTO CUSTOMERS (ID, NAME, ADDRESS, NUMBER_OF_ORDERS) VALUES (:customerId, :name, :address, :noOfOrdersMade )";
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", customer.getCustomerId());
        params.put("name", customer.getName());
        params.put("address", customer.getAddress());
        params.put("noOfOrdersMade", customer.getNoOfOrdersMade());
        jdbcTemplate.update(SQL, params);
    }

    private static final class CustomerMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerId(rs.getLong("ID"));
            customer.setName(rs.getString("NAME"));
            customer.setAddress(rs.getString("ADDRESS"));
            customer.setNoOfOrdersMade(rs.getLong("NUMBER_OF_ORDERS"));
            return customer;
        }
    }
}
