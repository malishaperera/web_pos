package lk.ijse.web_pos_backend.utill;

import java.util.UUID;

public class AppUtil {

    private static int customerCounter = 0;

    public static String createCustomerID(){
        customerCounter++;
        return String.format("CUS-%03d", customerCounter);
    }

}
