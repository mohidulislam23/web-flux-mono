package com.bjitacademy.webfluxmono.practise;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ErrorHandling {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------------------------------");
        Flux.just(2,7,10)
                .concatWith(Flux.error(new RuntimeException("Exception occured")))
                .concatWith(Mono.just(5))
                .onErrorReturn(67)
                .log()
                .subscribe()
                ;
        System.out.println("--------------------------------------------------------------------------------");

        Flux.just(2,7,10)
                //.concatWith(Flux.error(new RuntimeException("Exception occured")))
                .concatWith(Mono.just(5))
                .onErrorReturn(72)
                .log()
                .subscribe()
                ;
        System.out.println("--------------------------------------------------------------------------------");

        Flux.just(2,7,10)
                .concatWith(Flux.error(new RuntimeException("Exception occured")))
                .concatWith(Mono.just(5))
                //.onErrorReturn(72)
                .onErrorResume(err->{
                    System.out.println("error caught: " + err);
                    return Mono.just(72);
                })
                .log()
                .subscribe()
                ;
        System.out.println("--------------------------------------------------------------------------------");

        Flux.just(2,7,10)
                //.concatWith(Flux.error(new RuntimeException("Exception occured")))
                .concatWith(Mono.just(5))
                .map(element->{
                    if(element == 7){
                        throw new RuntimeException("Exception occured");
                    }
                    return element;
                })
                .onErrorContinue((ex,el)->{
                    System.out.println("error calught: " + ex);
                    System.out.println("element that cause exception: " + el);
                })
                .log()
                .subscribe()
                ;
        System.out.println("--------------------------------------------------------------------------------");

//
//        Flux.just(15,10,20).map(el->{
//            if(el == 10){
//                throw new RuntimeException("Exception occured");
//            }
//            return el;
//        }).onErrorMap(ex->{
//            System.out.println("error caught: " + ex);
//            return new Exception(ex.getMessage() + " custom",ex);
//        }).log().subscribe();

        System.out.println("--------------------------------------------------------------------------------");

        Flux.just(15,10,20).concatWith(Flux.error(new RuntimeException("Exception occurred")))
				.doOnError(ex-> System.out.println("exception caught: "+ex))
				.log()
				.subscribe();

    }
}
