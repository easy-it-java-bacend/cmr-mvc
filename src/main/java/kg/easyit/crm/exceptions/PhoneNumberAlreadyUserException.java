package kg.easyit.crm.exceptions;

public class PhoneNumberAlreadyUserException extends RuntimeException {
    public PhoneNumberAlreadyUserException(String message) {
        super(message);
    }
}
