package com.tinyurl.api.component.strategy.tinyURLcreation;

public interface TinyURLCreateStrategy {

    public String createTiny(String input);

    public StrategyTinyURLChoice getStrategyName();

}
