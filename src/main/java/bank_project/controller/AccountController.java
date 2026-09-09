package bank_project.controller;

import bank_project.dto.DepositRequest;
import bank_project.dto.TransactionResponse;
import bank_project.dto.WithdrawalRequest;
import bank_project.entity.Account;
import bank_project.entity.Customer;
import bank_project.entity.Transaction;
import bank_project.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
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
    @PostMapping("/account/{accountid}/deposit")
    public Object deposit(@PathVariable Long accountid, @Valid@RequestBody  DepositRequest depositRequest){
        return accountService.deposit(accountid,depositRequest);
    }
    @GetMapping("account/{accountid}/transactions")

    public List<TransactionResponse> getallTransactions(@PathVariable Long accountid){
        return accountService.getAllTransactions(accountid);
    }

    @PostMapping("/account/{accountid}/withdrawal")
    public Object withdrawal(@PathVariable Long accountid, @Valid@RequestBody WithdrawalRequest withdrawalRequest){
        return accountService.witdrawal(accountid,withdrawalRequest);
    }
}