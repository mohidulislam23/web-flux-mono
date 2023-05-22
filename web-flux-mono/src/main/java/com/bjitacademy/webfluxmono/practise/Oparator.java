package com.bjitacademy.webfluxmono.practise;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Oparator {
    //private static String value;

    public static void main(String[] args) {
        System.out.println("--------------------string to upper case----------------------------------------------------------");
        Flux.fromArray(new String[]{"mohidul", "islam", "shohag"}).map(String::toUpperCase).subscribe(System.out::println);
//        Output ---------------------------------------------------------------------
//        MOHIDUL
//        ISLAM
//        SHOHAG

        System.out.println("------------------------------String filtered by containing `m`------------------------------------------------");
        Flux.fromArray(new String[]{"mohidul", "islam", "shohag"}).filter(name->name.contains("m")).map(String::toUpperCase).subscribe(System.out::println);

        System.out.println("---------------------------map calling method---------------------------------------------------");

        Flux.fromArray(new String[]{"mohidul", "islam", "shohag"}).filter(name->name.contains("m")).map(Oparator::stringMono).subscribe(System.out::println);

        System.out.println("----------------------------------flatmap calling method -------------------------------------------");

        Flux.fromArray(new String[]{"mohidul", "islam", "shohag"}).filter(name->name.contains("m")).flatMap(Oparator::stringMono).subscribe(System.out::println);


    }
    private static Mono<String> stringMono(String value){
        return Mono.just(value.concat(" : updated"));
    }
}
