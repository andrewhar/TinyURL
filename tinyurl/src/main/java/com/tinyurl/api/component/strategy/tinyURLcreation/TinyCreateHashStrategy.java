package com.tinyurl.api.component.strategy.tinyURLcreation;

import org.springframework.stereotype.Component;

@Component
public class TinyCreateHashStrategy implements TinyURLCreateStrategy {

    private String idToShortURL(int i) {
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        StringBuilder sb = new StringBuilder();
        while (i > 0) {
            sb.append(map[i % 62]);
            i = i / 62;
        }
        return sb.reverse().toString();
    }


    @Override
    public String createTiny(String input) {
        String suffix = idToShortURL(Integer.parseInt(input));
        return "www.tinyurl.com/" + suffix;
    }

    @Override
    public StrategyTinyURLChoice getStrategyName() {
        return StrategyTinyURLChoice.HASHING;
    }
}
