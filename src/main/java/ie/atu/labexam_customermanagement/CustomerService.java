package ie.atu.labexam_customermanagement;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository;
    private List<Customer>customerList = new ArrayList<>();

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer>getCustomerById(String customerId){
        customerRepository.findById(customerId);
        return customerRepository.findAll();
    }

    public List<Customer>createCustomer(Customer customer){
        customerRepository.save(customer);
        return customerRepository.findAll();
    }

    public List<Customer>updateCustomer(String customerId, Customer customer){
        if(customerRepository.existsById(customerId)){
            customer.setCustomerId(customerId);
            customerRepository.save(customer);
        }
        return customerRepository.findAll();
    }
}
