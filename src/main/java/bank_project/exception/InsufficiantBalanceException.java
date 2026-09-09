package bank_project.exception;

public class InsufficiantBalanceException extends RuntimeException{
    public InsufficiantBalanceException(String message) {
        super(message);
    }
}
