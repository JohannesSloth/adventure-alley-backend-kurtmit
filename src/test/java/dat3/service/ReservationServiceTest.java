package dat3.service;

import dat3.adventure.dto.EmployeeRequest;
import dat3.adventure.dto.EmployeeResponse;
import dat3.adventure.entity.Employee;
import dat3.adventure.entity.Reservation;
import dat3.adventure.repository.EmployeeRepository;
import dat3.adventure.repository.ReservationRepository;
import dat3.adventure.service.EmployeeService;
import dat3.adventure.service.ReservationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ReservationServiceTest {
    public ReservationService reservationService;
    public static ReservationRepository reservationRepository;

    @BeforeAll
    public static void setupReservations(@Autowired ReservationRepository reservationRepository1){
        reservationRepository1.deleteAll();
        reservationRepository = reservationRepository1;
        reservationRepository.save(new Reservation(5, ));
        reservationRepository.save(new Employee("Jørgen", "Str", "Str", "Str"));
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
    void findByEmployeeIdTest() {
        assertEquals("Skørgen", employeeService.findByEmployeeId(1).getEmployeeName());
        assertEquals("Jørgen", employeeService.findByEmployeeId(2).getEmployeeName());
    }
    @Test
    void editEmployeeTest() throws Exception{
        //Change employee
        EmployeeRequest request = new EmployeeRequest(new Employee("Mørgen","LolTurneringsManager", "MørgLol", "pw"));
        employeeService.editEmployee(request, 2);
        //Verify the changes
        EmployeeResponse response = employeeService.findByEmployeeId(2);
        assertEquals("Mørgen", response.getEmployeeName());
        assertEquals("LolTurneringsManager", response.getRole());
        assertEquals("MørgLol", response.getUsername());

    }

    @Test
    void deleteEmployeeByIdTest(){
        employeeRepository.deleteById(1);
        assertEquals(1, employeeRepository.count());
    }

    @Test
    void addEmployeeTest(){
        Employee employee = new Employee("Lørgen", "SubnauticaManager", "LørgLogin", "LørgPW");
        EmployeeRequest request = new EmployeeRequest(employee);
        employeeService.addEmployee(request);
        assertEquals(3, employeeRepository.count());
    }
}
