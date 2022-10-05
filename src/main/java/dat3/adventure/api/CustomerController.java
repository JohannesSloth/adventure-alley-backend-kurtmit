package dat3.adventure.api;

import dat3.adventure.service.CustomerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/customers")
public class CustomerController {
    CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
}