package com.sda.javapoz11.hellospring.hellospring.service;

import com.sda.javapoz11.hellospring.hellospring.entity.Payment;

public interface PaymentActions {
    Payment findById(long id);

    void addPayment(String client, Double price);
}
