package dat3.adventure.dto;

import dat3.adventure.entity.Customer;

public class CustomerResponse {

  int customerId;
  String customerName;
  String customerEmail;
  String phoneNumber;
  String companyName;
  String cvrNumber;

  public CustomerResponse(Customer c, boolean isCompany) {
    this.customerId = c.getCustomerId();
    this.customerName = c.getCustomerName();
    this.customerEmail = c.getCustomerEmail();
    this.phoneNumber = c.getCompanyName();
    if (isCompany) {
      this.companyName = c.getCompanyName();
      this.cvrNumber = c.getCvrNumber();
    }
  }
}
