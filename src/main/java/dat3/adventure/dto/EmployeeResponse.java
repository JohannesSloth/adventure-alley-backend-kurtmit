package dat3.adventure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.adventure.entity.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {

    int employeeId;
    String employeeName;
    String role;
    String username;
    String password;

    /*@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    LocalDateTime edited;*/

    public EmployeeResponse(Employee e) {
        this.employeeId = e.getEmployeeId();
        this.employeeName = e.getEmployeeName();
        this.role = e.getRole();
        this.username = e.getUsername();
        this.password = e.getPassword();
    }



}
