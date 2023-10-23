package com.example.newssubscription.subscription;

import com.example.newssubscription.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.v1.prefix}")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;


    @PostMapping(
        value = "/subscribe",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<SubscriptionResponse> subscribe(
        @RequestBody SubscriptionRequest subscriptionRequest
    ) {
        SubscriptionResponse response = subscriptionService.subscribe(subscriptionRequest);
        return ResponseEntity.ok(response);
    }

}
