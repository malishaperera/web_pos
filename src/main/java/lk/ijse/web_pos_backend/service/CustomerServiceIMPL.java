package lk.ijse.web_pos_backend.service;

import jakarta.transaction.Transactional;
import lk.ijse.web_pos_backend.dao.CustomerDao;
import lk.ijse.web_pos_backend.dto.impl.CustomerDTO;
import lk.ijse.web_pos_backend.entity.CustomerEntity;
import lk.ijse.web_pos_backend.exception.CustomerNotFoundException;
import lk.ijse.web_pos_backend.exception.DataPersistFailedException;
import lk.ijse.web_pos_backend.utill.AppUtil;
import lk.ijse.web_pos_backend.utill.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private final CustomerDao customerDao;

    @Autowired
    private final Mapping mapping;

    //Save Customer
    public void saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setCustomerId(AppUtil.createCustomerID());
        var customerEntity = mapping.convertToCustomerEntity(customerDTO);
        var saveCustomer = customerDao.save(customerEntity);
        if (saveCustomer == null) {
            throw new DataPersistFailedException("Can't save customer");
        }
    }


    //Update Customer
    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {
        Optional<CustomerEntity> tmpNoteEntity = customerDao.findById(customerId);
        if(!tmpNoteEntity.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            tmpNoteEntity.get().setCustomerName(customerDTO.getCustomerName());
            tmpNoteEntity.get().setCustomerAddress(customerDTO.getCustomerAddress());
            tmpNoteEntity.get().setCustomerMobile(customerDTO.getCustomerMobile());
        }

    }
}
