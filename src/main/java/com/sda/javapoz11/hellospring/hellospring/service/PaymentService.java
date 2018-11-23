package com.sda.javapoz11.hellospring.hellospring.service;

import com.sda.javapoz11.hellospring.hellospring.entity.Payment;
import com.sda.javapoz11.hellospring.hellospring.entity.PaymentStatus;
import com.sda.javapoz11.hellospring.hellospring.repository.PaymentRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.time.temporal.TemporalAmount;

@Profile("!dev")
@Service
public class PaymentService implements PaymentActions {

    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment findById(long id) {
        return paymentRepository.findById(id)
                .orElse(null);
    }

    @Override
    public void addPayment(String client, Double price) {
        Payment payment = new Payment(null, client, price, Instant.now(), PaymentStatus.IN_PROGRESS);
        paymentRepository.save(payment);
    }

    @PostConstruct
    private void init() {
        paymentRepository.save(Payment.builder()
                .client("Jan Kowalski")
                .price(45.0)
                .date(Instant.now().minusSeconds(7 * 24 * 60 * 60))
                .status(PaymentStatus.DONE)
                .build());
        paymentRepository.save(Payment.builder()
                .client("Jan Kowalski")
                .price(30.0)
                .date(Instant.now().minusSeconds(1 * 24 * 60 * 60))
                .status(PaymentStatus.IN_PROGRESS)
                .build());
        paymentRepository.save(Payment.builder()
                .client("Anna Wisniewska")
                .price(45.0)
                .date(Instant.now().minusSeconds(21 * 24 * 60 * 60))
                .status(PaymentStatus.CANCELED)
                .build());
    }
}
