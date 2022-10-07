package dat3.adventure.configuration;

import dat3.adventure.entity.Activity;
import dat3.adventure.entity.Customer;
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



        Customer customer = new Customer("Smørgen", "Smørgen@yahoo.dk", "88888888", "Leasy", "876865");
        Activity activity = new Activity("Spille kiks", 4, 35, 6900);
        Reservation reservation = new Reservation(5,"07/10","11:15",customer.getCustomerId(),activity);

        customerRepository.save(customer);
        activityRepository.save(activity);
        reservationRepository.save(reservation);

    }
}
