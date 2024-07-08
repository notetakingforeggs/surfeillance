package com.northcoders.surfeillance.service.apis.tidalapi.daomodel;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TidesDTO {
    Date lowWaterTime;
    Double lowWaterHeight;
    Date highWaterTime;
    Double highWaterHeight;

    public TidesDTO(List<TidalEvent> events) {
        if (events.getFirst().getEventType().equals("LowWater")) {
            processLowWater(events.getFirst());
            processHighWater(events.get(1));
        } else {
            processHighWater(events.getFirst());
            processLowWater(events.get(1));
        }
    }

    private void processLowWater(TidalEvent event) {
        this.lowWaterTime = event.getDateTime();
        this.lowWaterHeight = event.getHeight();
    }

    private void processHighWater(TidalEvent event) {
        this.highWaterTime = event.getDateTime();
        this.highWaterHeight = event.getHeight();
    }


}
