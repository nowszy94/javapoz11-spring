package com.sda.javapoz11.hellospring.hellospring.service;

import com.sda.javapoz11.hellospring.hellospring.entity.Payment;
import com.sda.javapoz11.hellospring.hellospring.entity.PaymentStatus;
import com.sda.javapoz11.hellospring.hellospring.repository.PaymentRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Profile("dev")
@Service
public class NewPaymentsWithDoneStatusPaymentService implements PaymentActions {

    private PaymentRepository paymentRepository;

    public NewPaymentsWithDoneStatusPaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment findById(long id) {
        return paymentRepository.findById(id)
                .orElse(null);
    }

    @Override
    public void addPayment(String client, Double price) {
        Payment payment = new Payment(null, client, price, Instant.now(), PaymentStatus.DONE);
        paymentRepository.save(payment);
    }
}
