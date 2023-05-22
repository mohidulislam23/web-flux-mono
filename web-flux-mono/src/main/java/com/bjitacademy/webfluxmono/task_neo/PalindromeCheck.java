package com.bjitacademy.webfluxmono.task_neo;

import reactor.core.publisher.Mono;

public class PalindromeCheck {

    public static void main(String[] args) {
        String word = "level";

        checkPalindrome(Mono.just(word))
                .doOnNext(System.out::println)
                .block();
    }

    public static Mono<Boolean> checkPalindrome(Mono<String> wordMono) {
        return wordMono
                .map(word -> {
                    String reversed = new StringBuilder(word).reverse().toString();
                    return word.equalsIgnoreCase(reversed);
                });
    }
}
