package com.sda.javapoz11.hellospring.hellospring.controller;

import com.sda.javapoz11.hellospring.hellospring.entity.Payment;
import com.sda.javapoz11.hellospring.hellospring.service.PaymentActions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {
    private PaymentActions paymentActions;

    public PaymentController(PaymentActions paymentActions) {
        this.paymentActions = paymentActions;
    }

    @GetMapping("/payment/{id}")
    public Payment paymentById(@PathVariable("id") Long id) {
        return paymentActions.findById(id);
    }

    @PostMapping("/payment")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPayment(
            @RequestParam("client") String client,
            @RequestParam("price") Double price) {
        paymentActions.addPayment(client, price);
    }
}
