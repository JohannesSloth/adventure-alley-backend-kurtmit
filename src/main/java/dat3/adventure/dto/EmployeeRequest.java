package dat3.adventure.dto;

import dat3.adventure.entity.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeRequest {
    int employeeId;
    String employeeName;
    String role;
    String username;
    String password;

    public static Employee getEmployeeEntity(EmployeeRequest erq){
        return new Employee(erq.getEmployeeId(), erq.getEmployeeName(), erq.getRole(), erq.getUsername(), erq.getPassword());
    }

    public EmployeeRequest (Employee e) {
        this.employeeId = e.getEmployeeId();
        this.employeeName = e.getEmployeeName();
        this.role = e.getRole();
        this.username = e.getUsername();
        this.password = e.getPassword();

    }
}
