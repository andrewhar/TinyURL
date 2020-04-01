package com.tinyurl.api.service.strategy.tinyURLcreation;

import org.springframework.stereotype.Component;

@Component
public class TinyCreateIDStrategy implements TinyURLCreateStrategy {
    @Override
    public String createTiny(String input) {
        return "www.tinyurl.com/"+input;
    }
}
