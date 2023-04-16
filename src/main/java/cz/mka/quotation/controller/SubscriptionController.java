package cz.mka.quotation.controller;

import cz.mka.quotation.model.Subscription;
import cz.mka.quotation.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<Subscription> saveNewSubscription(@RequestBody Subscription subscription) {
        Subscription s = subscriptionService.createNewSubscription(subscription);
        if (s == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscription> findOneSubscription(@PathVariable Long id) {
        Optional<Subscription> s = subscriptionService.findOneSubscription(id);
        return s.map(subscription -> new ResponseEntity<>(subscription, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
