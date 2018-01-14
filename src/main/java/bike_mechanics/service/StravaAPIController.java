package bike_mechanics.service;

import javastrava.api.v3.auth.AuthorisationService;
import javastrava.api.v3.auth.impl.retrofit.AuthorisationServiceImpl;
import javastrava.api.v3.auth.model.Token;
import javastrava.api.v3.model.StravaActivity;
import javastrava.api.v3.service.Strava;
import org.springframework.stereotype.Component;

@Component
public class StravaAPIController {

    final private String ACCESS_TOKEN = "";
    final private String CLIENT_SECRET = "";
    final private int APPLICATION_CLIENT_ID = 0;
    final private int SAMPLE_ACTIVITY_ID = 1350511909;
    final private String CODE = "9a0e7be9902753ace66175e04faff6dfdeb4293e";

    private Strava stravaAPI;

    public StravaAPIController(){
        Token authorizationToken = this.authorizeForStravaAPI();
        this.stravaAPI = new Strava(authorizationToken);
        System.out.println("StravaAPIController initialized");
    }

    private Token authorizeForStravaAPI(){
        AuthorisationService service = new AuthorisationServiceImpl();
        Token token = service.tokenExchange(this.APPLICATION_CLIENT_ID, this.CLIENT_SECRET, this.CODE);
        return token;
    }

    public float getDistanceFromSampleActivity(){
        StravaActivity activity = this.stravaAPI.getActivity(this.SAMPLE_ACTIVITY_ID);
        return activity.getDistance();
    }

}
