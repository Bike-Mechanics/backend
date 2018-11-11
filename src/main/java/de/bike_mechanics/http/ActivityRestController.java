package de.bike_mechanics.http;

import de.bike_mechanics.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ActivityRestController {
    private final ApiService apiService;

    @Autowired
    public ActivityRestController(ApiService apiService){
        this.apiService = apiService;
    }

    @PutMapping(value = "/synch")
    public void synchronizeActivities(){
        this.apiService.synchActivities(2018);
    }

    @GetMapping(value = "/activity/{activityId}")
    public String activity(@PathVariable(value="activityId") int activityId){
        float activityDistance = this.apiService.getDistanceFromSampleActivity(activityId);
        return String.format("The distance of your activity was %s kilometers. Well done!", activityDistance);
    }
}
