package com.bruno.paymentservice.service;

import com.bruno.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);

}
