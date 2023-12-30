package com.PaymentService.services;

import com.PaymentService.paymentGateways.PaymentGateway;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class PaymentAppService {
    public PaymentGateway paymentGateway;
    public PaymentAppService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }
    public String generatePaymentLink(String orderId) throws StripeException {
        return paymentGateway.getPaymentLink(50000L,null,null);
    }
}
