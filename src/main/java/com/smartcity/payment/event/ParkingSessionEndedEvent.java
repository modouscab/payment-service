package com.smartcity.payment.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ParkingSessionEndedEvent {

    private Long sessionId;
    private Long parkingId;
    @JsonProperty("carPlate")
    private String plate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}