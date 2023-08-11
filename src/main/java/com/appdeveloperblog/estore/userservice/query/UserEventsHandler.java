package com.appdeveloperblog.estore.userservice.query;

import com.appdeveloperblog.estore.core.model.PaymentDetails;
import com.appdeveloperblog.estore.core.model.User;
import com.appdeveloperblog.estore.core.query.FetchUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserEventsHandler {

    @QueryHandler
    public User findUserPaymentDetails(FetchUserPaymentDetailsQuery query) {
        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("123Card")
                .cvv("123")
                .name("BOB BIMO")
                .validUntilMonth(12)
                .validUntilYear(2030)
                .build();

        User userRest = User.builder()
                .firstName("bob")
                .lastName("bimo")
                .userId(query.getUserId())
                .paymentDetails(paymentDetails)
                .build();

        return userRest;
    }
}
