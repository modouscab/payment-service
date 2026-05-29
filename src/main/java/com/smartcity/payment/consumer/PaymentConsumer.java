package com.smartcity.payment.consumer;

import com.smartcity.payment.event.ParkingSessionEndedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentConsumer {

    @KafkaListener(topics = "parking-session-ended", groupId = "payment-group")
    public void consume(ParkingSessionEndedEvent event) {

        log.info("Event reçu: {}", event);

        // Calcul simple
        long duration = java.time.Duration
                .between(event.getStartTime(), event.getEndTime())
                .toMinutes();

        double price = duration * 0.05;

        log.info("Paiement calculé pour {} : {} CAD", event.getPlate(), price);
    }
}