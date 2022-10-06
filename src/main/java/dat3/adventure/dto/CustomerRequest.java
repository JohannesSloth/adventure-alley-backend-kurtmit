package dat3.adventure.dto;


import dat3.adventure.entity.Activity;
import dat3.adventure.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CustomerRequest {

  int customerId;
  String customerName;
  String customerEmail;
  String phoneNumber;
  String companyName;
  String cvrNumber;

  public static Customer getCustomerEntity(CustomerRequest crq){
    return new Customer(crq.getCustomerId(), crq.getCustomerName(), crq.getCustomerEmail(), crq.getPhoneNumber(),
        crq.getCompanyName(), crq.getCvrNumber());
  }

  public CustomerRequest(Customer c) {
    this.customerName = c.getCustomerName();
    this.customerEmail = c.getCustomerEmail();
    this.phoneNumber = c.getPhoneNumber();
    this.companyName = c.getCompanyName();
    this.cvrNumber = c.getCvrNumber();
  }

  public CustomerRequest(int customerId, String customerName, String customerEmail, String phoneNumber) {
    this.customerId = customerId;
    this.customerName = customerName;
    this.customerEmail = customerEmail;
    this.phoneNumber = phoneNumber;
  }
}
