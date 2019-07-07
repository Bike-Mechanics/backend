package de.bike_mechanics.http;

import de.bike_mechanics.persistence.entities.Wheelset;
import de.bike_mechanics.persistence.repositories.WheelsetRepository;
import de.bike_mechanics.domain.service.BikeComponentUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;


@RestController
public class ActivityRestController {

    private final BikeComponentUsageService bikeComponentUsageService;

    private final WheelsetRepository wheelsetRepository;

    @Autowired
    public ActivityRestController(BikeComponentUsageService bikeComponentUsageService, WheelsetRepository wheelsetRepository){
        this.bikeComponentUsageService = bikeComponentUsageService;
        this.wheelsetRepository = wheelsetRepository;
    }

    @GetMapping(value = "/activity/{activityId}")
    public String activity(@PathVariable(value="activityId") int activityId){
        int activityDistance = 50;
        return String.format("The distance of your activity was %s kilometers. Well done!", activityDistance);
    }

    @GetMapping(value = "/doStuff")
    public String doStuff(){
        Wheelset wheelset = new Wheelset();
        this.wheelsetRepository.save(wheelset);

        ZonedDateTime start = createDateTime(2017, 10, 1);
        ZonedDateTime end = createDateTime(2018, 3, 30);

        this.bikeComponentUsageService.createUsage(wheelset, start, end);

        start = createDateTime(2018, 10, 1);

        this.bikeComponentUsageService.createUsage(wheelset, start);
        return "Success";
    }

    static ZonedDateTime createDateTime(int year, int month, int day){
        return ZonedDateTime.of(year, month, day, 0, 0, 0, 0, ZoneId.of("CET"));
    }
}
