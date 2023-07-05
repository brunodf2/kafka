package com.bruno.paymentservice.service.impl;

import com.bruno.paymentservice.model.Payment;
import com.bruno.paymentservice.service.PaymentService;
import java.io.Serializable;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("Received the payment {}", payment);
        Thread.sleep(1000);

        log.info("Sending payment...");
        kafkaTemplate.send("payment-topic", payment);
    }

}
