package dat3.adventure.api;

import dat3.adventure.dto.ActivityRequest;
import dat3.adventure.dto.ActivityResponse;
import dat3.adventure.service.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/activities")
public class ActivityController {
    ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<ActivityResponse> getActivities() {
        return activityService.getActivities();
    }

    @GetMapping("/{activityName}")
    public ActivityResponse getActivityById(@PathVariable String activityName) throws Exception {
        ActivityResponse response = activityService.getActivityById(activityName);
        return response;
    }

    @PostMapping
    public ActivityResponse addActivity(@RequestBody ActivityRequest body) {
        return activityService.addActivity(body);
    }

    @PutMapping("/{activityName}")
    public ResponseEntity<Boolean> editActivity(@RequestBody ActivityRequest body, @PathVariable String activityName) {
        activityService.editActivity(body, activityName);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @DeleteMapping("/{activityName}")
    public void deleteActivityByName(@PathVariable String activityName) {
        activityService.deleteByName(activityName);
    }
}
