package dat3.adventure.api;


import dat3.adventure.dto.EmployeeRequest;
import dat3.adventure.dto.EmployeeResponse;
import dat3.adventure.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeResponse> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping
    public EmployeeResponse addEmployee(@RequestBody EmployeeRequest body) {
        return employeeService.addEmployee(body);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Boolean> editEmployee(@RequestBody EmployeeRequest body, @PathVariable int employeeId) {
        employeeService.editEmployee(body, employeeId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById(@PathVariable int employeeId) {
        employeeService.deleteEmployeeById(employeeId);
    }

    @GetMapping("/{employeeId}")
    public EmployeeResponse getEmployeeById(@PathVariable int employeeId) {
        EmployeeResponse response = employeeService.findByEmployeeId(employeeId);
        return response;
    }


}
