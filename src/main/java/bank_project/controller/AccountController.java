package bank_project.controller;

import bank_project.entity.Account;
import bank_project.entity.Customer;
import bank_project.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account, @RequestParam Long customerId){
        return accountService.createAccount(account,customerId);
    }
   @GetMapping("/account")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }
    @GetMapping("/account/{id}")
    public Optional<Account> GetByid(@PathVariable Long id){
       return accountService.getById(id);
    }

}