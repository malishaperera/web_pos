package lk.ijse.web_pos_backend.exception;

public class DataPersistFailedException extends RuntimeException {
    public DataPersistFailedException(String message) {
        super(message);
    }
}
