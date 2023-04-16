package cz.mka.quotation.service;

import cz.mka.quotation.model.Subscription;
import cz.mka.quotation.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionServiceDefault implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription createNewSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Optional<Subscription> findOneSubscription(Long id) {
        return subscriptionRepository.findById(id);
    }


}
