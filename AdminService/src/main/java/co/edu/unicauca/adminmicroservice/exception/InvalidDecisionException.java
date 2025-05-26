package co.edu.unicauca.adminmicroservice.exception;
public class InvalidDecisionException extends RuntimeException {
    public InvalidDecisionException(String message) {
        super(message);
    }
}