package dat3.adventure.configuration;

import dat3.adventure.entity.Activity;
import dat3.adventure.entity.Customer;
import dat3.adventure.entity.Employee;
import dat3.adventure.entity.Reservation;
import dat3.adventure.repository.ActivityRepository;
import dat3.adventure.repository.CustomerRepository;
import dat3.adventure.repository.EmployeeRepository;
import dat3.adventure.repository.ReservationRepository;
import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import dat3.security.repository.UserWithRolesRepository;

import java.time.LocalDateTime;

@Controller
public class SetupDevUsers implements ApplicationRunner {

    UserWithRolesRepository userWithRolesRepository;
    String passwordUsedByAll;
    ReservationRepository reservationRepository;
    CustomerRepository customerRepository;
    EmployeeRepository employeeRepository;
    ActivityRepository activityRepository;

    public SetupDevUsers(UserWithRolesRepository userWithRolesRepository, ReservationRepository reservationRepository,
                         CustomerRepository customerRepository, EmployeeRepository employeeRepository,
                         ActivityRepository activityRepository) {
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.activityRepository = activityRepository;
        this.userWithRolesRepository = userWithRolesRepository;
        passwordUsedByAll = "test12";
    }

    @Override
    public void run(ApplicationArguments args) {
        setupUserWithRoleUsers();
    }

    /*****************************************************************************************
     NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL
     iT'S ONE OF THE TOP SECURITY FLAWS YOU CAN DO
     *****************************************************************************************/
    private void setupUserWithRoleUsers() {
        System.out.println("******************************************************************************");
        System.out.println("******* NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL ************");
        System.out.println("******* REMOVE THIS BEFORE DEPLOYMENT, AND SETUP DEFAULT USERS DIRECTLY  *****");
        System.out.println("**** ** ON YOUR REMOTE DATABASE                 ******************************");
        System.out.println("******************************************************************************");
        UserWithRoles user1 = new UserWithRoles("user1", passwordUsedByAll, "user1@a.dk");
        UserWithRoles user2 = new UserWithRoles("user2", passwordUsedByAll, "user2@a.dk");
        UserWithRoles user3 = new UserWithRoles("user3", passwordUsedByAll, "user3@a.dk");
        user1.addRole(Role.USER);
        user1.addRole(Role.ADMIN);
        user2.addRole(Role.USER);
        user3.addRole(Role.ADMIN);
        userWithRolesRepository.save(user1);
        userWithRolesRepository.save(user2);
        userWithRolesRepository.save(user3);

        Employee employee1 = new Employee("Jürgen", "Medarbejder", "j", "j");
        employeeRepository.save(employee1);

        Customer customer = new Customer("Smørgen", "Smørgen@yahoo.dk", "88888888", "Leasy", "876865");
        customer = customerRepository.save(customer);

        Activity activity1 = new Activity("sumo", 15, 140, 200);
        activity1 = activityRepository.save(activity1);
        Activity activity2 = new Activity("gokart", 16, 135, 300);
        activity2 = activityRepository.save(activity2);
        Activity activity3 = new Activity("minigolf", 7, 80, 100);
        activity3 = activityRepository.save(activity3);
        Activity activity4 = new Activity("paintball", 18, 145, 400);
        activity4 = activityRepository.save(activity4);

        Reservation reservation1 = reservationRepository.save(new Reservation(1, "10102022","09",customer.getCustomerId(),activity1.getActivityName()));
        reservation1 = reservationRepository.save(reservation1);
        Reservation reservation2 = reservationRepository.save(new Reservation(2, "11102022","11",customer.getCustomerId(),activity1.getActivityName()));
        reservation2 = reservationRepository.save(reservation2);
        Reservation reservation3 = reservationRepository.save(new Reservation(3, "12102022","12",customer.getCustomerId(),activity1.getActivityName()));
        reservation3 = reservationRepository.save(reservation3);
        Reservation reservation4 = reservationRepository.save(new Reservation(4, "13102022","16",customer.getCustomerId(),activity1.getActivityName()));
        reservation4 = reservationRepository.save(reservation4);


        customerRepository.save(customer);
        activityRepository.save(activity1);
        activityRepository.save(activity2);
        activityRepository.save(activity3);
        activityRepository.save(activity4);
        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
        reservationRepository.save(reservation3);
        reservationRepository.save(reservation4);
    }
}
