package ie.atu.labexam_customermanagement;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;
    List<Customer>customerList = new ArrayList<>();

    public CustomerController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @GetMapping("/getCustomers")
    public List<Customer>getAllCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<Customer>>getCustomerById(@PathVariable String customerId){
        customerList = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customerList);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<List<Customer>> addCustomer(@Valid @RequestBody Customer customer){
        customerList = customerService.createCustomer(customer);
        return ResponseEntity.ok(customerList);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<List<Customer>> updateCustomer(@PathVariable String customerId, @RequestBody Customer updatedCustomer){
        customerList = customerService.updateCustomer(customerId, updatedCustomer);
        return ResponseEntity.ok(customerList);
    }


}
