package com.bjitacademy.webfluxmono.practise;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Conversion {
    public static void main(String[] args) {
        Flux<String> flux = Flux.just("data1", "data2"); // flux to mono, use .next()
        Mono<String> next = flux.next();

        Mono<String> data2 = Mono.just("data2"); // mono to flex, use .from()
        Flux<String> monoFlux = Flux.from(data2);

        Flux<String> flux1 = Flux.just("data1", "data2"); //
        flux1.log().subscribe();
//
//        > Task :Conversion.main()
//        09:37:59.895 [main] DEBUG reactor.util.Loggers -- Using Slf4j logging framework
//        09:37:59.994 [main] INFO reactor.Flux.Array.1 -- | onSubscribe([Synchronous Fuseable] FluxArray.ArraySubscription)
//        09:37:59.997 [main] INFO reactor.Flux.Array.1 -- | request(unbounded)
//        09:37:59.998 [main] INFO reactor.Flux.Array.1 -- | onNext(data1)
//        09:37:59.998 [main] INFO reactor.Flux.Array.1 -- | onNext(data2)
//        09:37:59.999 [main] INFO reactor.Flux.Array.1 -- | onComplete()

    }
}
