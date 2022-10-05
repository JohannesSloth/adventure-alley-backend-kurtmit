package dat3.ActivityTest;

import dat3.adventure.dto.ActivityResponse;
import dat3.adventure.entity.Activity;
import dat3.adventure.repository.ActivityRepository;
import dat3.adventure.service.ActivityService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ActivityControllerTest {

    public ActivityService activityService;
    public static ActivityRepository activityRepository;

    @BeforeAll
    public static void setupActivity(@Autowired ActivityRepository activityRepository1){
        activityRepository1.deleteAll();
        activityRepository = activityRepository1;
        activityRepository.save(new Activity("Gokart", 15, 140,450));
        activityRepository.save(new Activity("Sumo", 18, 170,650));
    }

    @BeforeEach
    void setupeach(){
    activityService = new ActivityService(activityRepository);
    }

    @Test
    void checkForActivity() {
        assertEquals(3, activityService.getActivities().size());
    }
}
