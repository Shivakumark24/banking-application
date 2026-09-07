package bank_project.service;

import bank_project.entity.Account;
import bank_project.entity.Customer;
import bank_project.repository.AccountRepository;
import bank_project.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
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

}
