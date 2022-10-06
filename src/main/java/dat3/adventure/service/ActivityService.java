package dat3.adventure.service;

import dat3.adventure.dto.ActivityRequest;
import dat3.adventure.dto.ActivityResponse;
import dat3.adventure.entity.Activity;
import dat3.adventure.repository.ActivityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ActivityService {
  private ActivityRepository activityRepository;

  public ActivityService(ActivityRepository activityRepository) {
    this.activityRepository = activityRepository;
  }

  public List<ActivityResponse> getActivities() {
    List<Activity> activities = activityRepository.findAll();
    List<ActivityResponse> response = activities.stream().map(activity -> new ActivityResponse(activity)).collect(Collectors.toList());
    return response;

  }

  public ActivityResponse addActivity(ActivityRequest activityRequest) {
    if (activityRepository.existsById(activityRequest.getActivityName())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Activiteten med dette navn findes allerede.");
    }

    Activity newActivity = ActivityRequest.getActivityEntity(activityRequest);
    activityRepository.save(newActivity);

    return new ActivityResponse(newActivity);
  }

  public void editActivity(ActivityRequest body, String name) {
    //Activity activity = ActivityRequest.getActivityEntity(body);

    Activity activity = activityRepository.findById(name).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "En aktivitet eksisterer med dette navn"));

    if (!body.getActivityName().equalsIgnoreCase(name)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Kan ikke finde aktiviteten med dette navn");
    } else {
      activity.setActivityName(body.getActivityName());
      activity.setEquipment(body.getEquipment());
      activity.setMinimumAge(body.getMinimumAge());
      activity.setMinimumHeight(body.getMinimumHeight());
      activity.setPricePerHour(body.getPricePerHour());
      activity.setReservation(body.getReservation());
    }

    activityRepository.save(activity);
  }

  public ActivityResponse getActivityByName(String activityName) {
    return new ActivityResponse(activityRepository.findById(activityName).get());
  }
}
