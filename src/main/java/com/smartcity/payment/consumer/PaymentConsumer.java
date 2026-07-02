package com.smartcity.payment.consumer;

import com.smartcity.payment.event.ParkingSessionEndedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
public class PaymentConsumer {

    @KafkaListener(topics = "parking-session-ended", groupId = "payment-group-v2")
    public void consume(ParkingSessionEndedEvent event) {

        log.info("Event reçu: {}", event);

        // Calcul simple
        /*long duration = java.time.Duration
                .between(event.getStartTime(), event.getEndTime())
                .toMinutes();

        double price = duration * 0.05;*/

        Duration duration =
                Duration.between(event.getStartTime(), event.getEndTime());

        long seconds = duration.getSeconds();

        long billableMinutes =
                (long) Math.ceil(seconds / 60.0);

        double price = billableMinutes * 0.05;

        log.info("Durée réelle : {} secondes", seconds);

        log.info("Minutes facturées : {}", billableMinutes);

        log.info("Montant : {} CAD", price);

        log.info("Paiement calculé pour {} : {} CAD", event.getPlate(), price);
    }
}