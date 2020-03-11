package com.epam.database01.db;

import com.epam.database01.model.Customer;

import java.util.List;

public interface Displayable {
    void createCollection();
    List<Customer> getCustomers();
}
