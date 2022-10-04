package dat3.adventure.api;

import dat3.adventure.service.ActivityService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/activities")
public class ActivityController {
    ActivityService activityService;

    public ActivityController(ActivityService activityService){
        this.activityService = activityService;
    }
}
