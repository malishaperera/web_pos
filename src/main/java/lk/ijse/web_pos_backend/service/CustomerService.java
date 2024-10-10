package lk.ijse.web_pos_backend.service;

import lk.ijse.web_pos_backend.dto.impl.CustomerDTO;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    void updateCustomer(String customerId, CustomerDTO customerDTO);

    void deleteCustomer(String customerId);
}
