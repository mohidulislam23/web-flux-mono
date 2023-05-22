package com.bjitacademy.webfluxmono.practise;

import reactor.core.publisher.Flux;

public class Callbacks {
    public static void main(String[] args) {
//        Flux.just("a","b","c").doOnSubscribe(subscription -> System.out.println("subscription: " + subscription)).subscribe();
        Flux.just("a","b","c").doOnSubscribe(subscription -> System.out.println("Subscription: " +subscription))
                .doOnNext(val-> System.out.println("Values: "+ val)).subscribe();
    }
}
