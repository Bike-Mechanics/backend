package de.bike_mechanics.domain.representation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComponentUsageDTO {
    private Long componentId;

    private Float distance;
}
