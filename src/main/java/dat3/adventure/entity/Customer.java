package dat3.adventure.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int customerId;

  @Column(length= 50, nullable = false)
  String customerName;

  @Column(length= 50, nullable = false)
  String customerEmail;

  @Column(length= 50, nullable = false)
  String phoneNumber;

  @Column(length= 50)
  String companyName;

  @Column(length= 50)
  String cvrNumber;

  public Customer(String customerName, String customerEmail, String phoneNumber, String companyName, String cvrNumber) {
    this.customerName = customerName;
    this.customerEmail = customerEmail;
    this.phoneNumber = phoneNumber;
    this.companyName = companyName;
    this.cvrNumber = cvrNumber;
  }
}
