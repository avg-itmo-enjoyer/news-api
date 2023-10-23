package com.example.newssubscription.subscription;

import com.example.newssubscription.category.Category;
import com.example.newssubscription.category.CategoryRepository;
import com.example.newssubscription.user.User;
import com.example.newssubscription.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public SubscriptionResponse subscribe(SubscriptionRequest request) {

        final String email = request.getEmail();
        final String categoryName = request.getCategory();

        final User user = userRepository
            .findByEmail(email)
            .orElse(null);
        if (user == null)
            return new SubscriptionResponse(
                SubscriptionResponse.SubscriptionResponseStatus.FAILURE,
                "No user with such email"
            );

        final Category category = categoryRepository
            .findByName(categoryName)
            .orElse(null);
        if (category == null)
            return new SubscriptionResponse(
                SubscriptionResponse.SubscriptionResponseStatus.FAILURE,
                "No such news category"
            );

        user.getSubscriptions().add(category);
        userRepository.save(user);

        return new SubscriptionResponse(
            SubscriptionResponse.SubscriptionResponseStatus.SUCCESS,
            "Successfully subscribed"
        );
    }
}
