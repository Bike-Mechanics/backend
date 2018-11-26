package de.bike_mechanics.service;

import de.bike_mechanics.persistence.entities.Activity;
import de.bike_mechanics.persistence.entities.Use;
import de.bike_mechanics.persistence.entities.Wheelset;
import de.bike_mechanics.persistence.entities.base.BikeComponent;
import de.bike_mechanics.persistence.repositories.ActivityRepository;
import de.bike_mechanics.persistence.repositories.UseRepository;
import de.bike_mechanics.persistence.repositories.WheelsetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BikeComponentUsageService {

    private final ActivityRepository activityRepository;

    private final WheelsetRepository wheelsetRepository;

    private final UseRepository useRepository;

    private List<Activity> getAllActivities(){
       return this.activityRepository.findAll();
    }

    public void createUsage(BikeComponent bikeComponent, ZonedDateTime start, ZonedDateTime end) {
        Use newUse = new Use(start, end);

        this.saveAndCalculateDistance(bikeComponent, newUse);
    }

    public void createUsage(BikeComponent bikeComponent, ZonedDateTime start) {
        Use newUse = new Use(start);

        this.saveAndCalculateDistance(bikeComponent, newUse);
    }


    private float getActiviesDistance(Use use){
        List<Activity> activities = this.getAllActivities();
        float sumDistance = 0;

        ZonedDateTime start = use.getAssemblyDate();

        ZonedDateTime end;
        if(use.getDisassemblyDate() == null){
            end = ZonedDateTime.now();
        }else{
            end = use.getDisassemblyDate();
        }

        for (Activity activity: activities) {
            if(activity.getCreatedOn().isAfter(start) && activity.getCreatedOn().isBefore(end)){
                sumDistance += activity.getDistance();
            }
        }
        return sumDistance;
    }


    private void saveAndCalculateDistance(BikeComponent bikeComponent, Use newUse) {
        newUse.setDistance(this.getActiviesDistance(newUse));
        bikeComponent.addUse(newUse);


        if (bikeComponent instanceof Wheelset) {
            this.wheelsetRepository.save((Wheelset) bikeComponent);
        }
    }
}
