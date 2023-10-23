package com.example.newssubscription.subscription;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionRequest {
    @Email(
        message = "Invalid email address",
        regexp = "^(.+)@(\\S+)$"
    )
    private String email;
    private String category;
}
