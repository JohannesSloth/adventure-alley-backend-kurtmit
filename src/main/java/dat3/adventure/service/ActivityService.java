package dat3.adventure.service;

import dat3.adventure.dto.ActivityResponse;
import dat3.adventure.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActivityService  {
    private ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }
    //public List<ActivityResponse> getActivities(){
        //activityRepository.get()
   // }


}
