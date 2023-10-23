package com.example.newssubscription.subscription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionResponse {

    enum SubscriptionResponseStatus {
        SUCCESS, FAILURE;
    }

    private SubscriptionResponseStatus status;
    private String msg;
}
