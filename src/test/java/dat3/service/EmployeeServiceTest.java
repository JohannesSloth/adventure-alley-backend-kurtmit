package dat3.service;

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
    public static void setupEmployees(@Autowired EmployeeRepository employeeRepository1){
        employeeRepository1.deleteAll();
        employeeRepository = employeeRepository1;
        employeeRepository.save(new Employee("Skørgen","Str","Str","Str"));
        employeeRepository.save(new Employee("Jørgen", "Str", "Str", "Str"));
    }

    @BeforeEach
    void setupEach(){
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    void getEmployeesTest() {
        assertEquals(2, employeeService.getEmployees().size());
    }
    @Test
    void findByEmployeeId() throws Exception {
        assertEquals("Skørgen", employeeService.findByEmployeeId(1).getEmployeeName());
        assertEquals("Jørgen", employeeService.findByEmployeeId(2).getEmployeeName());
    }
}
