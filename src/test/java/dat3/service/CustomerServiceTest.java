package dat3.service;

import dat3.adventure.dto.ActivityRequest;
import dat3.adventure.dto.ActivityResponse;
import dat3.adventure.dto.CustomerRequest;
import dat3.adventure.dto.CustomerResponse;
import dat3.adventure.entity.Activity;
import dat3.adventure.entity.Customer;
import dat3.adventure.repository.ActivityRepository;
import dat3.adventure.repository.CustomerRepository;
import dat3.adventure.service.ActivityService;
import dat3.adventure.service.CustomerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CustomerServiceTest {

  public CustomerService customerService;
  public static CustomerRepository customerRepository;

  @BeforeAll
  public static void setupCustomer(@Autowired CustomerRepository CustomerRepository1){
    CustomerRepository1.deleteAll();
    customerRepository = CustomerRepository1;
    customerRepository.save(new Customer("Lars Knud","l@g.dk","1","Wonnegut","1"));
    customerRepository.save(new Customer("Jens Knud","j@g.dk","2","Wonnegut","2"));
  }

  @BeforeEach
  void setupeach(){
    customerService = new CustomerService(customerRepository);
  }

  @Test
  void checkForCustomer() {
    assertEquals(2, customerService.getCustomers().size());
  }

  @Test
  void editCustomerTest() {
    CustomerRequest request = new CustomerRequest(new Customer("gg","gg.dk","gg","gg","gg"));
    customerService.editCustomer(request, 1);
    CustomerResponse response = customerService.getCustomerById(1);
    assertEquals("gg.dk", response.getCustomerEmail());
  }


}
