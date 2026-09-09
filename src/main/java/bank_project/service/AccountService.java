package bank_project.service;

import bank_project.dto.DepositRequest;
import bank_project.dto.TransactionResponse;
import bank_project.dto.WithdrawalRequest;
import bank_project.entity.Account;
import bank_project.entity.Customer;
import bank_project.entity.Transaction;
import bank_project.exception.AccountNotFoundException;
import bank_project.exception.InsufficiantBalanceException;
import bank_project.repository.AccountRepository;
import bank_project.repository.CustomerRepository;
import bank_project.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import bank_project.exception.AccountNotActiveException;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }
    public Account createAccount(Account account,Long customerId){
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        account.setCustomer(customer);
        return accountRepository.save(account);
    }
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
    public Optional<Account> getById(Long id){
        return accountRepository.findById(id);
    }
    @Transactional
    public Object deposit(Long accountid,  DepositRequest depositRequest) {
        Account account = accountRepository.findById(accountid).orElseThrow(()->new AccountNotFoundException("Account npt Found"));
        if (!"ACTIVE".equals(account.getStatus())) {
            throw new AccountNotActiveException("Account is not active");
        }
        account.setBalance(account.getBalance().add(depositRequest.getAmount()));
        Transaction transaction=new Transaction(depositRequest.getAmount(),"DEPOSIT","SUCCESS",account);
         accountRepository.save(account);
         transactionRepository.save(transaction);
         return transaction;

    }
    public List<TransactionResponse> getAllTransactions(Long id) {

        List<Transaction> transactions =
                transactionRepository.findByAccount_AccountId(id);

        List<TransactionResponse> responses = new ArrayList<>();

        for (Transaction transaction : transactions) {

            TransactionResponse response = new TransactionResponse();

            response.setTransactionId(transaction.getTransactionId());
            response.setAmount(transaction.getAmount());
            response.setType(transaction.getType());
            response.setStatus(transaction.getStatus());
            response.setCreatedAt(transaction.getCreatedAt());

            responses.add(response);
        }

        return responses;
    }
    @Transactional
    public TransactionResponse witdrawal(Long accountid, WithdrawalRequest withdrawalRequest){
         Account account = accountRepository.findById(accountid).orElseThrow(()->new AccountNotFoundException("Account not Found"));
         if(account.getBalance().compareTo(withdrawalRequest.getAmount())<0){
             throw new InsufficiantBalanceException("insufficient balance");
          }
        if (!"ACTIVE".equals(account.getStatus())) {
            throw new AccountNotActiveException("Account is not active");
        }
         account.setBalance(account.getBalance().subtract(withdrawalRequest.getAmount()));
        accountRepository.save(account);
        Transaction transaction=new Transaction(withdrawalRequest.getAmount(),"WITHDRAWAL","SUCCESS",account);
         transactionRepository.save(transaction);
         TransactionResponse transactionResponse=new TransactionResponse(withdrawalRequest.getAmount(),transaction.getTransactionId(),transaction.getType(),transaction.getStatus(),transaction.getCreatedAt());
         return transactionResponse;
    }
}
