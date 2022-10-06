package dat3.adventure.service;


import dat3.adventure.dto.EmployeeRequest;
import dat3.adventure.dto.EmployeeResponse;
import dat3.adventure.entity.Employee;
import dat3.adventure.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeResponse> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> response = employees.stream().map(employee -> new EmployeeResponse(employee)).collect(Collectors.toList());
        return response;
    }

    public EmployeeResponse findByEmployeeId(int employeeId) {
        Employee found = employeeRepository.findById(employeeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with this ID not found"));
        return new EmployeeResponse(found);
    }

    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRepository.existsById(employeeRequest.getEmployeeId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee with this ID already exists");
        }
        Employee newEmployee = EmployeeRequest.getEmployeeEntity(employeeRequest);
        newEmployee = employeeRepository.save(newEmployee);

        return new EmployeeResponse(newEmployee);
    }

    public void editEmployee(EmployeeRequest body, int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't find employee with this ID"));
        //employee.setEmployeeId(body.getEmployeeId());
        employee.setEmployeeName(body.getEmployeeName());
        employee.setRole(body.getRole());
        employee.setUsername(body.getUsername());
        employee.setPassword(body.getPassword());
        employeeRepository.save(employee);
    }

    public void deleteEmployeeById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
