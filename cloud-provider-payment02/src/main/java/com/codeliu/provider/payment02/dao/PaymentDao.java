package com.codeliu.provider.payment02.dao;

import com.codeliu.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
