package dat3.adventure.api;

import dat3.adventure.dto.CustomerRequest;
import dat3.adventure.dto.CustomerResponse;
import dat3.adventure.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/customers")
public class CustomerController {
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerResponse> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    public CustomerResponse addCustomer(@RequestBody CustomerRequest body) {
        return customerService.addCustomer(body);
    }

    @PutMapping
    public ResponseEntity<Boolean> editCustomer(@RequestBody CustomerRequest body, @PathVariable int id) {
        customerService.editCustomer(body, id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteCustomerByID(@PathVariable int id) {
        customerService.deleteById(id);
    }
}
