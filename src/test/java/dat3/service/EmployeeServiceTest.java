/*package dat3.service;

import dat3.adventure.dto.EmployeeRequest;
import dat3.adventure.entity.Employee;
import dat3.adventure.repository.EmployeeRepository;
import dat3.adventure.service.EmployeeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class EmployeeServiceTest {
    public EmployeeService employeeService;
    public static EmployeeRepository employeeRepository;

    @BeforeAll
    public static void setupEmployee(@Autowired EmployeeRepository employeeRepository1){
        employeeRepository = employeeRepository1;
        employeeRepository.save(new Employee(100, "Jørgen", "GoKart Manager", "jørggokart", "123"));
        employeeRepository.save(new Employee(101, "Skørgen","Sumo Manager", "skørsumo", "1234"));
        /*employeeService.addEmployee(new EmployeeRequest(100, "Jørgen", "GoKart Manager", "jørggokart", "123" ));
        employeeService.addEmployee(new EmployeeRequest(101, "Skørgen","Sumo Manager", "skørsumo", "1234" ));

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;}
    @BeforeEach
    public void setEmployeeService(){
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    void checkEmployeeAmount() {
        assertEquals(2, employeeService.getEmployees().size());
    }

    @Test
    void checkEmployeeNames() throws Exception {
        assertEquals("Jørgen", employeeService.findByEmployeeId(100).getEmployeeName());
        assertEquals("Skørgen", employeeService.findByEmployeeId(101).getEmployeeName());
    }
}*/
