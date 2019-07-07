package de.bike_mechanics.domain.service;

import de.bike_mechanics.domain.representation.ComponentUsageDTO;
import de.bike_mechanics.persistence.entities.Activity;
import de.bike_mechanics.persistence.entities.Chain;
import de.bike_mechanics.persistence.entities.ComponentUsage;
import de.bike_mechanics.persistence.entities.Wheelset;
import de.bike_mechanics.persistence.entities.base.BikeComponent;
import de.bike_mechanics.persistence.repositories.ActivityRepository;
import de.bike_mechanics.persistence.repositories.ChainRepository;
import de.bike_mechanics.persistence.repositories.UsageRepository;
import de.bike_mechanics.persistence.repositories.WheelsetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BikeComponentUsageService {

    private final ActivityRepository activityRepository;

    private final WheelsetRepository wheelsetRepository;

    private final ChainRepository chainRepository;

    private final UsageRepository usageRepository;

    private final StravaAPI stravaAPI;

    private List<Activity> getAllActivities() {
        return this.activityRepository.findAll();
    }

    public void createUsage(BikeComponent bikeComponent, ZonedDateTime start, ZonedDateTime end) {
        ComponentUsage newUse = new ComponentUsage(start, end);

        this.saveAndCalculateDistance(bikeComponent, newUse);
    }

    public ComponentUsageDTO calculateDistanceForComponent(long id) {
        Chain chain = new Chain();
        chain = chainRepository.save(chain);

        ZonedDateTime assemblyDate = ZonedDateTime.of(2018, 1, 1, 0, 0, 0, 0, ZoneId.of("Europe/Berlin"));

        ComponentUsage usage = new ComponentUsage(assemblyDate);
        chain.addUsage(usage);

        List<Activity> activities = stravaAPI.getActivities();
        activities.forEach(activity -> {
            this.appendDistanceIfInUse(activity, usage);
        });

        chainRepository.save(chain);

        return new ComponentUsageDTO(chain.getId(), usage.getDistance());
    }

    private void appendDistanceIfInUse(Activity activity, ComponentUsage usage) {
        if (usage.getDisassemblyDate() != null) {
            return;
        }

        if (activity.getCreatedOn().isBefore(usage.getAssemblyDate())) {
            return;
        }

        usage.addDistance(activity.getDistance());
    }

    public void createUsage(BikeComponent bikeComponent, ZonedDateTime start) {
        ComponentUsage newUse = new ComponentUsage(start);

        this.saveAndCalculateDistance(bikeComponent, newUse);
    }


    private float getActiviesDistance(ComponentUsage use) {
        List<Activity> activities = this.getAllActivities();
        float sumDistance = 0;

        ZonedDateTime start = use.getAssemblyDate();

        ZonedDateTime end;
        if (use.getDisassemblyDate() == null) {
            end = ZonedDateTime.now();
        } else {
            end = use.getDisassemblyDate();
        }

        for (Activity activity : activities) {
            if (activity.getCreatedOn().isAfter(start) && activity.getCreatedOn().isBefore(end)) {
                sumDistance += activity.getDistance();
            }
        }
        return sumDistance;
    }


    private void saveAndCalculateDistance(BikeComponent bikeComponent, ComponentUsage newUse) {
        newUse.setDistance(this.getActiviesDistance(newUse));
        bikeComponent.addUsage(newUse);


        if (bikeComponent instanceof Wheelset) {
            this.wheelsetRepository.save((Wheelset) bikeComponent);
        }
    }
}
