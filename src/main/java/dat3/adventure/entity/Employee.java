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
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int employeeId;

  @Column(length= 50, nullable = false)
  String employeeName;

  @Column(length= 50, nullable = false)
  String role;

  @Column(length= 50, nullable = false)
  String username;

  @Column(length= 50, nullable = false)
  String password;

}
