package lk.ijse.web_pos_backend.dao;

import lk.ijse.web_pos_backend.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity,String> {

    // Fetches a CustomerEntity by its unique customerId.
    CustomerEntity getCustomerByCustomerId(String customerId);
}
