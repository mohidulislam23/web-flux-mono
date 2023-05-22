package com.bjitacademy.webfluxmono.practise;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Concate {
    public static void main(String[] args) {
        Flux<String> flux1 = Flux.just("a", "b", "c","y");
        Flux<String> flux2 = Flux.just("d", "e", "f","i");

        // perform concat flux1  && flux2
        System.out.println("\nperform concat flux1  && flux2");
        Flux<String> concat = Flux.concat(flux1, flux2);
        concat.subscribe(System.out::println);

        // perform concat flux1  && eMono
        System.out.println("\nperform concat flux1  && eMono");
        Mono<String> eMono = Mono.just("e");
        flux1.concatWith(eMono);
        flux1.concatWith(eMono).subscribe(System.out::println);

        // zip method
        System.out.println("\nperform zip method flux1  && flux2");
        Flux.zip(flux1,flux2,(flux_x,flux_y)->flux_x+flux_y).subscribe(System.out::println);

        //zip method merge fuction
        System.out.println("\nperform zip method merge fuction flux1  && flux2");

//        StepVerifier.create(returnMerged())
//                .expectNext("a")
//                .expectNext("d")
//                .expectNext("b")
//                .expectNext("e")
//                .expectNext("c")
//                .expectNext("f")
//                .expectComplete()
//                .verify();


    }



    public static Flux<String> returnMerged(){
        Flux<String> flux1 = Flux.fromArray(new String[]{"m", "n", "o"}).delayElements(Duration.ofMillis(100));
        Flux<String> flux2 = Flux.fromArray(new String[]{"p", "q", "r"}).delayElements(Duration.ofMillis(120));
        return Flux.merge(flux1,flux2);
    }
}
