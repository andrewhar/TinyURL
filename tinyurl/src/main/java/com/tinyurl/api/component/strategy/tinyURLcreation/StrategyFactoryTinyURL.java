package com.tinyurl.api.component.strategy.tinyURLcreation;

import org.springframework.stereotype.Component;

@Component
public class StrategyFactoryTinyURL {

    public TinyURLCreateStrategy factoryMethod(StrategyTinyURLChoice choice) {
        TinyURLCreateStrategy res = null;
        switch (choice) {
            case SIMPLE_NUMBER:
                res = new TinyCreateIDStrategy();
                break;
            case HASHING:
                res = new TinyCreateHashStrategy();
                break;
        }

        return res;
    }


}
