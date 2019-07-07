package de.bike_mechanics.domain.service;

import de.bike_mechanics.persistence.entities.Activity;
import de.bike_mechanics.persistence.entities.Chain;
import de.bike_mechanics.persistence.entities.ComponentUsage;
import de.bike_mechanics.persistence.entities.Wheelset;
import de.bike_mechanics.persistence.entities.base.BikeComponent;
import de.bike_mechanics.persistence.repositories.ActivityRepository;
import de.bike_mechanics.persistence.repositories.ChainRepository;
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

    private final ChainRepository chainRepository;

    private final UseRepository useRepository;

    private List<Activity> getAllActivities(){
       return this.activityRepository.findAll();
    }

    public void createUsage(BikeComponent bikeComponent, ZonedDateTime start, ZonedDateTime end) {
        ComponentUsage newUse = new ComponentUsage(start, end);

        this.saveAndCalculateDistance(bikeComponent, newUse);
    }

    public void calculateDistanceForComponent(long id){

        /*

        [GET] /components/15
        {
            "component_id": 15,
            "componenten_name": "My Chain",
            "km_usage": 2400
        }

        1. Create Chain entity (create new simple entity... without CRUD management)
        2. Create Component Usage (...)
        3. Import activities (call mocked StravaAPI with getActivities())
        4. Recalculate component usage ()
        5. Data interface for data return

         */

        Chain chain = new Chain();
        chainRepository.save(chain);

    }

    public void createUsage(BikeComponent bikeComponent, ZonedDateTime start) {
        ComponentUsage newUse = new ComponentUsage(start);

        this.saveAndCalculateDistance(bikeComponent, newUse);
    }


    private float getActiviesDistance(ComponentUsage use){
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


    private void saveAndCalculateDistance(BikeComponent bikeComponent, ComponentUsage newUse) {
        newUse.setDistance(this.getActiviesDistance(newUse));
        bikeComponent.addUse(newUse);


        if (bikeComponent instanceof Wheelset) {
            this.wheelsetRepository.save((Wheelset) bikeComponent);
        }
    }
}
