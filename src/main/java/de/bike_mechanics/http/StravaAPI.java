package de.bike_mechanics.http;

import de.bike_mechanics.persistence.entities.Activity;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

public class StravaAPI {

    public List<Activity> getActivities() {

        ZonedDateTime ect1 = ZonedDateTime.of(2018, 01, 15, 12, 00, 00, 0, ZoneId.of("ECT"));
        Activity activity1 = new Activity(1, 84193, 32510.0f, ect1);

        ZonedDateTime ect2 = ZonedDateTime.of(2018, 15, 15, 12, 00, 00, 0, ZoneId.of("ECT"));
        Activity activity2 = new Activity(1, 84193, 32510.0f, ect2);

        ZonedDateTime ect3 = ZonedDateTime.of(2018, 15, 18, 12, 00, 00, 0, ZoneId.of("ECT"));
        Activity activity3 = new Activity(1, 84193, 32510.0f, ect3);


        return Arrays.asList(activity1, activity2, activity3);
    }

}
