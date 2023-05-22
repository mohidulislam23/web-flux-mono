package com.bjitacademy.webfluxmono.practise;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Practise {
    public static void main(String[] args) {
        System.out.println("\nMonoExample\n------------------------------------------------------------------");
        Mono<String> monoString = Mono.just( "data");
        System.out.println("\nmonoString\n------------------------------------------------------------------");
        monoString.subscribe(data-> System.out.println(data), err -> System.out.println(err),()-> System.out.println("Completed."));

        //error example
        Mono<Object> monoException = Mono.fromSupplier(()->{
            throw new RuntimeException("exception");

        });
        System.out.println("\nmonoException\n------------------------------------------------------------------");
        monoException.subscribe(data-> System.out.println(data), err -> System.out.println(err),()-> System.out.println("Completed."));

        System.out.println("\nFluxExample\n------------------------------------------------------------------");
        Flux<String> fluxData = Flux.just("data", "data1","data2");
        fluxData.subscribe(data -> System.out.println(data), err -> System.out.println(err), () -> System.out.println("Completed."));

        List<String> listString = new ArrayList<>();
        listString.add("val");
        listString.add("val1");
        Flux<String> stringFlux = Flux.fromIterable(listString);
        stringFlux.subscribe(data -> System.out.println(data), err -> System.out.println(err), () -> System.out.println("Completed."));

        Flux.range(1,5).subscribe(System.out::println);


    }
}
