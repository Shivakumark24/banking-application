package bank_project.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AccountNotFoundException.class)
    ResponseEntity<String> handleAccountNotFound(AccountNotFoundException ex){
        return ResponseEntity.status(404).body("Account not found");
    }
    @ExceptionHandler(AccountNotActiveException.class)
    ResponseEntity<String> handleAccountNotActive(AccountNotActiveException  ex){
        return ResponseEntity.status(403).body("Status is Not Active");
    }
    @ExceptionHandler(InsufficiantBalanceException.class)
    ResponseEntity<String> InsufficiantBalanceException(InsufficiantBalanceException  ex){
        return ResponseEntity.status(403).body("Status is Not Active");
    }

}

