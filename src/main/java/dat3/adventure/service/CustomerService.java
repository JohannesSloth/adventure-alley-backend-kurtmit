package dat3.adventure.service;

import dat3.adventure.dto.ActivityRequest;
import dat3.adventure.dto.ActivityResponse;
import dat3.adventure.dto.CustomerRequest;
import dat3.adventure.dto.CustomerResponse;
import dat3.adventure.entity.Activity;
import dat3.adventure.entity.Customer;
import dat3.adventure.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        if (customerRepository.existsById(customerRequest.getCustomerId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Kunde med dette id findes allerede.");
        }
        Customer newCustomer = CustomerRequest.getCustomerEntity(customerRequest);
        customerRepository.save(newCustomer);
        if (newCustomer.getCustomerName().equalsIgnoreCase("null") || newCustomer.getCvrNumber() == null) {
            return new CustomerResponse(newCustomer, false);
        } else {
            return new CustomerResponse(newCustomer, true);
        }
    }

    public void editCustomer(CustomerRequest body, int id) {
    }

    public List<CustomerResponse> getCustomers() {
    }
}
