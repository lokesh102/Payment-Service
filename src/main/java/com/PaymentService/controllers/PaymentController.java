package com.PaymentService.controllers;

import com.PaymentService.DTOs.CreatePaymentLinkRequestDTO;
import com.PaymentService.services.PaymentAppService;
import com.stripe.exception.StripeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentAppService paymentAppService;
    public PaymentController(PaymentAppService paymentAppService){
        this.paymentAppService = paymentAppService;
    }
    @PostMapping("/link")
    public ResponseEntity<String> paymentLinkGeneration(@RequestBody CreatePaymentLinkRequestDTO requestDTO) throws StripeException {
        String paymentLink = paymentAppService.generatePaymentLink(requestDTO.getOrderId());
        return new ResponseEntity<String>(paymentLink,HttpStatus.OK);
    }
}
