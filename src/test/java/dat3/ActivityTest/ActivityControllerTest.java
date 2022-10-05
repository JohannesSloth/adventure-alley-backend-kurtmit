package dat3.ActivityTest;

import dat3.adventure.api.ActivityController;
import dat3.adventure.dto.ActivityRequest;
import dat3.adventure.entity.Activity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ActivityControllerTest {

    @Autowired
    ActivityController activityController;

    @BeforeEach
    void setupActivity(){
        activityController.addActivity(new ActivityRequest("Gokart", 15, 140,450));
        activityController.addActivity(new ActivityRequest("Sumo", 18, 170,650));
    }

    @Test
    void checkForActivity() {
        assertEquals(2, activityController.getActivities().size());
    }
}
