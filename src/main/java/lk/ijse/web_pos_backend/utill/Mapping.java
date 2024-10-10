package lk.ijse.web_pos_backend.utill;


import lk.ijse.web_pos_backend.dto.impl.CustomerDTO;
import lk.ijse.web_pos_backend.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;

    /**CustomerEntity to Convert CustomerDTO  and CustomerDTO to Convert CustomerEntity **/


    public CustomerEntity convertToCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    public CustomerDTO convertToCustomerDTO(CustomerEntity customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public List<CustomerDTO> convertCustomerToDTO(List<CustomerEntity> customerEntities) {
        return modelMapper.map(customerEntities, new TypeToken<List<CustomerDTO>>() {}.getType());
    }
}
