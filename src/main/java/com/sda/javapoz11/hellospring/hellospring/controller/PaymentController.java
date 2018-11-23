package com.sda.javapoz11.hellospring.hellospring.controller;

import com.sda.javapoz11.hellospring.hellospring.entity.Payment;
import com.sda.javapoz11.hellospring.hellospring.service.PaymentActions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController {
    private PaymentActions paymentActions;

    public PaymentController(PaymentActions paymentActions) {
        this.paymentActions = paymentActions;
    }

    @GetMapping("/api/payment/{id}")
    @ResponseBody
    public Payment paymentById(@PathVariable("id") Long id) {
        return paymentActions.findById(id);
    }

    @PostMapping("/api/payment")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void addPayment(
            @RequestParam("client") String client,
            @RequestParam("price") Double price) {
        paymentActions.addPayment(client, price);
    }

    @GetMapping("/payment/{id}")
    public ModelAndView paymentByIdView(@PathVariable("id") Long id) {
        Payment payment = paymentActions.findById(id);
        ModelAndView modelAndView = new ModelAndView("payment.html");
        modelAndView.addObject("payment", payment);
        return modelAndView;
    }

}
