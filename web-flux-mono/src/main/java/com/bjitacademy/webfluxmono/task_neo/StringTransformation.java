package com.bjitacademy.webfluxmono.task_neo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Flux;

public class StringTransformation {

    public static void main(String[] args) {
        String[] strings = {"mohidul", "islam"};

        transformStringArray(Flux.fromArray(strings))
                .doOnNext(System.out::println)
                .subscribe();
    }

    public static Flux<String> transformStringArray(Flux<String> stringFlux) {
        return stringFlux
                .map(String::toUpperCase)
                .map(s -> new StringBuilder(s).reverse().toString());
    }
}
