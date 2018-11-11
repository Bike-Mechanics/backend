package de.bike_mechanics.service;

import de.bike_mechanics.persistence.entities.Activity;
import de.bike_mechanics.persistence.repositories.ActivityRepository;
import javastrava.api.v3.model.StravaActivity;
import javastrava.api.v3.model.reference.StravaActivityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@PropertySource(value={"classpath:application.properties"})
public class ApiService {

    private StravaAuthorizedService stravaAuthorizedService;

    private ActivityRepository activityRepository;

    @Autowired
    public ApiService(StravaAuthorizedService stravaAuthorizedService, ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
        this.stravaAuthorizedService = stravaAuthorizedService;
        this.synchActivities(2018);
    }

    public float getDistanceFromSampleActivity(int activityId){
        StravaActivity activity = this.stravaAuthorizedService.getActivity(activityId);
        return activity.getDistance()/1000;
    }


    public void synchActivities(int year){
        for (int i = 1; i < 12; i++) {
            LocalDateTime after = LocalDateTime.of(year, i, 1, 0, 0);
            LocalDateTime before = LocalDateTime.of(year, i+1, 1, 0, 0).minusMinutes(1);
            List<StravaActivity> monthsActivities = this.stravaAuthorizedService.listAuthenticatedAthleteActivities(before, after);

            monthsActivities.forEach(fetchedStravaActivity -> {
                if(fetchedStravaActivity.getType() == StravaActivityType.RIDE) {

                    Activity activity = new Activity(fetchedStravaActivity.getId(), fetchedStravaActivity.getDistance(), fetchedStravaActivity.getStartDate());

                    this.activityRepository.save(activity);
                }
            });
        }

    }

}
