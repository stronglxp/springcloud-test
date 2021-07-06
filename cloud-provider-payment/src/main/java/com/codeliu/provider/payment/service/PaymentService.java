package com.codeliu.provider.payment.service;

import com.codeliu.entity.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
