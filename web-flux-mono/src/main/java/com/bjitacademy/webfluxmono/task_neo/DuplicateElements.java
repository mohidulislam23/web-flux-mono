package com.bjitacademy.webfluxmono.task_neo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicateElements {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8};

        findDuplicates(Flux.fromArray(array))
                .doOnNext(System.out::println).subscribe();
    }

    public static Mono<List<Integer>> findDuplicates(Flux<Integer> arrayFlux) {

        return arrayFlux
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .flatMapMany(map -> Flux.fromIterable(map.entrySet()))
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collectList();
    }
}
