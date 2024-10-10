package lk.ijse.web_pos_backend.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity implements SuperEntity {
    @Id
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerMobile;

}
