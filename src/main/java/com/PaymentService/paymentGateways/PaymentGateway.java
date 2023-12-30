package com.PaymentService.paymentGateways;

import com.stripe.exception.StripeException;

public interface PaymentGateway {
    String getPaymentLink(Long amount,String username, String phoneNumber) throws StripeException;
}
