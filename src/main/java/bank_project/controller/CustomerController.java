package bank_project.controller;
import bank_project.entity.Customer;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import bank_project.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
  private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/customers")
    public Customer createCustomer(@Valid  @RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
    @GetMapping("/customers")
    public List<Customer> getALLcustomer(){
        return customerService.getallcustomer();
    }
    @GetMapping("/customers/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id) {
        return customerService.getByCustomerId(id);
    }

}
