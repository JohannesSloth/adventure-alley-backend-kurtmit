package dat3.service;

import dat3.adventure.dto.ActivityRequest;
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
public class ActivityServiceTest {

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
        assertEquals(2, activityService.getActivities().size());
    }

    @Test
    void editActivityTest() {
        ActivityRequest request = new ActivityRequest("LOL turnering", 21, 160, 7000);

        assertEquals(15, activityService.getActivityByName("Gokart").getMinimumAge());
        assertEquals(140, activityService.getActivityByName("Gokart").getMinimumHeight());
        assertEquals(450, activityService.getActivityByName("Gokart").getPricePerHour());

        activityService.editActivity(request, "Gokart");

        assertEquals(21, activityService.getActivityByName("LOL turnering").getMinimumAge());
        assertEquals(160, activityService.getActivityByName("LOL turnering").getMinimumHeight());
        assertEquals(7000, activityService.getActivityByName("LOL turnering").getPricePerHour());

    }
}
