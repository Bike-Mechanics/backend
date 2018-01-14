package de.bike_mechanics.service;

import javastrava.api.v3.auth.AuthorisationService;
import javastrava.api.v3.auth.impl.retrofit.AuthorisationServiceImpl;
import javastrava.api.v3.auth.model.Token;
import javastrava.api.v3.model.StravaActivity;
import javastrava.api.v3.service.Strava;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@Component
@PropertySource(value={"classpath:application.properties"})
public class StravaAPIController {

    @Value(value = "${strava.access_token}")
    private String ACCESS_TOKEN;

    @Value(value = "${strava.client_secret}")
    private String CLIENT_SECRET;

    @Value(value = "${strava.client_id}")
    private int APPLICATION_CLIENT_ID;

    @Value(value = "${strava.sample_running_activity_id}")
    private int SAMPLE_RUNNING_ACTIVITY_ID;

    @Value(value = "${strava.sample_cycling_activity_id}")
    private int SAMLE_CYCLING_ACTIVITY_ID;

    @Value(value = "${strava.authorization_code}")
    private String CODE;

    private Strava stravaAPI;

    public StravaAPIController(){
        Token authorizationToken = this.authorizeForStravaAPI();
        this.stravaAPI = new Strava(authorizationToken);
        System.out.println("StravaAPIController initialized");
    }

    private Token authorizeForStravaAPI(){
        AuthorisationService service = new AuthorisationServiceImpl();
        System.out.println("Authorization with: " + this.APPLICATION_CLIENT_ID + "" + this.CLIENT_SECRET + "" + this.CODE);
        Token token = service.tokenExchange(this.APPLICATION_CLIENT_ID, this.CLIENT_SECRET, this.CODE);
        return token;
    }

    public float getDistanceFromSampleActivity(int activityId){
        StravaActivity activity = this.stravaAPI.getActivity(activityId);
        return activity.getDistance()/1000;
    }

}
