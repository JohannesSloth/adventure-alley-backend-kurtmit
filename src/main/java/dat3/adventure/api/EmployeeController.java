package dat3.adventure.api;


import dat3.adventure.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    EmployeeService employeeService;



}
