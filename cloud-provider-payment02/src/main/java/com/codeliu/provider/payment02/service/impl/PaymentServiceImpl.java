package com.codeliu.provider.payment02.service.impl;

import com.codeliu.entity.Payment;
import com.codeliu.provider.payment02.dao.PaymentDao;
import com.codeliu.provider.payment02.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
