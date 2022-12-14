package dat3.adventure.service;

import dat3.adventure.dto.CustomerRequest;
import dat3.adventure.dto.CustomerResponse;
import dat3.adventure.entity.Customer;
import dat3.adventure.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

        if (newCustomer.getCustomerName().equalsIgnoreCase("") || Objects.equals(newCustomer.getCvrNumber(), "")) {
            return new CustomerResponse(newCustomer, false);
        } else {
            return new CustomerResponse(newCustomer, true);
        }
    }

    public void editCustomer(CustomerRequest body, int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "En aktivitet eksisterer med dette ID"));

        customer.setCustomerEmail(body.getCustomerEmail());
        customer.setCustomerName(body.getCustomerName());
        customer.setPhoneNumber(body.getPhoneNumber());
        customer.setCompanyName(body.getCompanyName());
        customer.setCvrNumber(body.getCvrNumber());

        customerRepository.save(customer);
    }

    public List<CustomerResponse> getCustomers() {
        List<Customer> customers = customerRepository.findAll();

        List<CustomerResponse> response = customers.stream().map(customer -> {
            if (customerRepository.findById(customer.getCustomerId()).
                    orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                            "Kan ikke finde kunde med dette ID")).getCompanyName().equalsIgnoreCase("")) {
                return new CustomerResponse(customer, false);
            } else {
                return new CustomerResponse(customer, true);
            }
        }).collect(Collectors.toList());

        return response;
    }

    public CustomerResponse getCustomerById(int id) {
        Customer found = customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't find the customer"));

        if (found.getCustomerName().equalsIgnoreCase("null") || found.getCvrNumber() == null) {
            return new CustomerResponse(found, false);
        } else {
            return new CustomerResponse(found, true);
        }
    }

    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }
}
