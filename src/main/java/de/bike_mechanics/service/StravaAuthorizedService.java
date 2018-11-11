package de.bike_mechanics.service;

import javastrava.api.v3.auth.AuthorisationService;
import javastrava.api.v3.auth.impl.retrofit.AuthorisationServiceImpl;
import javastrava.api.v3.auth.model.Token;
import javastrava.api.v3.model.StravaActivity;
import javastrava.api.v3.service.Strava;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class StravaAuthorizedService {

    private Strava stravaApi;

    public StravaAuthorizedService(@Value("${strava.client_id}") int clientId,
                                   @Value("${strava.client_secret}") String clientSecret,
                                   @Value("${strava.authorization_code}") String code) {

        Token authorizationToken = this.authorizeForStravaAPI(clientId, clientSecret, code);
        this.stravaApi = new Strava(authorizationToken);
    }


    private Token authorizeForStravaAPI(int clientId, String clientSecret, String code) {
        AuthorisationService service = new AuthorisationServiceImpl();
        log.info("Authorization with: " + clientId + "" + clientSecret + "" + code);
        return service.tokenExchange(clientId, clientSecret, code);
    }

    StravaActivity getActivity(int activityId){
        return this.stravaApi.getActivity(activityId);
    }

    List<StravaActivity> listAuthenticatedAthleteActivities(LocalDateTime before, LocalDateTime after){
        return this.stravaApi.listAuthenticatedAthleteActivities(before, after);
    }


}
