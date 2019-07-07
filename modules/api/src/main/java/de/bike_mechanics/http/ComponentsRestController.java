package de.bike_mechanics.http;

import de.bike_mechanics.domain.service.BikeComponentUsageService;
import de.bike_mechanics.domain.representation.ComponentUsageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ComponentsRestController {

    private final BikeComponentUsageService bikeComponentUsageService;

    @GetMapping("/components")
    public ComponentUsageDTO retrieve() {
        return bikeComponentUsageService.calculateDistanceForComponent(2);
    }
}
