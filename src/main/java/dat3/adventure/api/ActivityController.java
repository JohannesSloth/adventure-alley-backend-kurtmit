package dat3.adventure.api;

import dat3.adventure.dto.ActivityRequest;
import dat3.adventure.dto.ActivityResponse;
import dat3.adventure.service.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/activities")
public class ActivityController {
    ActivityService activityService;

    public ActivityController(ActivityService activityService){
        this.activityService = activityService;
    }

    @GetMapping
    public List<ActivityResponse> getActivities(){
        return activityService.getActivities();
    }

    @PostMapping
    public ActivityResponse addActivity(@RequestBody ActivityRequest body){
        return activityService.addActivity(body);
    }
}
