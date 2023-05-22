package com.bjitacademy.webfluxmono.task_neo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ArrayRotation {

    public static void main(String[] args) {
        Integer[] array = {11, 22, 33, 44, 55};

        rotateArray(Flux.fromArray(array), 2)
                .doOnNext(rotatedArray -> {
                    for (Integer num : rotatedArray) {
                        System.out.print(num + " ");
                    }
                })
                .subscribe();
    }

    public static Mono<List<Integer>> rotateArray(Flux<Integer> arrayFlux, int rotationCount) {
        return arrayFlux
                .collectList()
                .flatMap(list -> {
                    List<Integer> rotatedArray = new ArrayList<>(list);
                    Collections.rotate(rotatedArray, rotationCount);
                    return Mono.just(rotatedArray);
                });
    }
}
