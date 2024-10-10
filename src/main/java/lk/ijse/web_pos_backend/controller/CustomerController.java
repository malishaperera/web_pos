package lk.ijse.web_pos_backend.controller;


import lk.ijse.web_pos_backend.dto.impl.CustomerDTO;
import lk.ijse.web_pos_backend.exception.DataPersistFailedException;
import lk.ijse.web_pos_backend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/health")
    public String healthCheck(){
        return "Customer is running";
    }


    //Save Customer
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerDTO customerDTO){
        if (customerDTO == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer cannot be null");
        }else {
            try {
                customerService.saveCustomer(customerDTO);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistFailedException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
