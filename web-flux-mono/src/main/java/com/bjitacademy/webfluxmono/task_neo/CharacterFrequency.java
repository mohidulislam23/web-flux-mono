package com.bjitacademy.webfluxmono.task_neo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequency {

    public static void main(String[] args) {
        String[] strings = {"Royal", "Bengal", "Tiger"};

        countCharacterFrequency(Flux.fromArray(strings))
                .doOnNext(System.out::println)
                .subscribe();
    }

    public static Flux<Map<Character, Integer>> countCharacterFrequency(Flux<String> stringFlux) {
        return stringFlux
                .flatMap(s -> Flux.fromStream(s.chars().mapToObj(c -> (char) c)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)))
                .flatMapMany(map -> Flux.just(map));
    }
}
