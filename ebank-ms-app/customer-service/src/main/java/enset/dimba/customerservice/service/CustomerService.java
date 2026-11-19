package enset.dimba.customerservice.service;

import enset.dimba.customerservice.entities.Customer;
import enset.dimba.customerservice.repository.CustomerRepository;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @McpTool(description = "Get All Customers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @McpTool(description = "Find a customers by id")
    public Customer findCustomerById(@McpToolParam(description = "The customer id") Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));
    }

    @McpTool(description = "Save a new customers")
    public  Customer saveCustomer(@McpToolParam(description = "The customer  to save(name, email)") Customer customer){
        return customerRepository.save(customer);
    }
}
