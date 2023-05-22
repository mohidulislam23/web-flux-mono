package com.bjitacademy.webfluxmono.practise;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

public class BackPressure {
    public static void main(String[] args) {
        Flux<Integer> range = Flux.range(1,100);
        range.log().subscribe(new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                request(10);
            }

            @Override
            protected void hookOnNext(Integer value) {
                if(value == 10){
                    cancel();
                }
            }
        });
    }
}
