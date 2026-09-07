package bank_project.service;
import bank_project.entity.Customer;
import bank_project.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Customer createCustomer( Customer customer) {
        return customerRepository.save(customer);
    }
    public List<Customer> getallcustomer(){
         return customerRepository.findAll();
    }
    public Optional<Customer>  getByCustomerId(Long id){
        return customerRepository.findById(id);
    }



}
