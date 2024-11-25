package redis.integration.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.integration.backend.Dtos.SubscriptionDto;
import redis.integration.backend.services.RedisService;
import redis.integration.backend.utils.TokenUtil;

@RestController()
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    RedisService redisService;

    @PostMapping
    public ResponseEntity<SubscriptionDto> createSubscription(@RequestBody SubscriptionDto subscriptionDto) {
        redisService.set(subscriptionDto.email(), TokenUtil.generate(), 20);
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionDto);
    }
}
