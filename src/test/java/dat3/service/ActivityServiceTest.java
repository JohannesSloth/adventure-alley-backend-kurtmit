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
        activityRepository.save(new Activity("gokart", 15, 140,450));
        activityRepository.save(new Activity("sumo", 18, 170,650));
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
        ActivityRequest request = new ActivityRequest(new Activity(21, 160, 7000));
        activityService.editActivity(request, "gokart");
        ActivityResponse response = activityService.getActivityById("gokart");
        assertEquals(21, response.getMinimumAge());
        assertEquals(160, response.getMinimumHeight());
        assertEquals(7000, response.getPricePerHour());
    }



}
