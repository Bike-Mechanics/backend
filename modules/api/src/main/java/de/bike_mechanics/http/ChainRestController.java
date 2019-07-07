package de.bike_mechanics.http;

import de.bike_mechanics.domain.service.BikeComponentUsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChainRestController {

    private final BikeComponentUsageService bikeComponentUsageService;

    @GetMapping("/components")
    public void retrieve() {
        bikeComponentUsageService.calculateDistanceForComponent(2);
    }

}
