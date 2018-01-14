package de.bike_mechanics.persistence.entities.notifications;
import de.bike_mechanics.persistence.base_entities.Notifcation;

import java.sql.Date;

public class MaintenanceNotification extends Notifcation {
    String message;
    Date date;
}
