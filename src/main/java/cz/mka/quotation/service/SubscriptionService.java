package cz.mka.quotation.service;

import cz.mka.quotation.model.Subscription;

import java.util.Optional;

public interface SubscriptionService {

    Subscription createNewSubscription(Subscription subscription);

    Optional<Subscription> findOneSubscription(Long id);
}
