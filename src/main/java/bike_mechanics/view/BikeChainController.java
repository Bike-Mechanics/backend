package bike_mechanics.view;

import bike_mechanics.persistence.entities.Bike;
import bike_mechanics.persistence.entities.Chain;
import bike_mechanics.persistence.repositories.BikeRepository;
import bike_mechanics.persistence.repositories.ChainRepository;
import bike_mechanics.service.StravaAPIController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class BikeChainController {

    private BikeRepository bikeRepository;

    private ChainRepository chainRepository;

    private StravaAPIController stravaAPIController;

    @Autowired
    public BikeChainController(StravaAPIController stravaAPIController, ChainRepository chainRepository, BikeRepository bikeRepository){
        this.stravaAPIController = stravaAPIController;
        this.bikeRepository = bikeRepository;
        this.chainRepository = chainRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        String randomId = UUID.randomUUID().toString();
        Bike bike = new Bike(randomId, "Stevens Aspin");
        Chain chain = new Chain();

        this.chainRepository.save(chain);
        bike.addChain(chain);
        this.bikeRepository.save(bike);
        ArrayList<Bike> bikes = (ArrayList<Bike>) this.bikeRepository.findAll();
        return "I got " + bikes.size() + " bike(s) saved.";
    }

    @RequestMapping(value = "/activity", method = RequestMethod.GET)
    public String activity(){
        float activityDistance = this.stravaAPIController.getDistanceFromSampleActivity();

        return "The distance of your activity was " + activityDistance + " kilometers. Well done!";
    }
}
