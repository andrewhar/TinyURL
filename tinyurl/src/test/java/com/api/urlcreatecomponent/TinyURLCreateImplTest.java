package com.api.urlcreatecomponent;

import com.tinyurl.api.exception.EmptyURLException;
import com.tinyurl.api.model.TinyURL;
import com.tinyurl.api.model.URL;
import com.tinyurl.api.component.strategy.tinyURLcreation.*;
import com.tinyurl.api.component.urlcreator.TinyURLCreateComponent;
import com.tinyurl.api.component.urlcreator.TinyURLCreateImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TinyURLCreateImplTest {

    private TinyURLCreateComponent tinyURLCreateComponent;

    @BeforeClass
    public static void beforeCreateImplTest() {
        System.out.println("Start testing tinyUrl create impl");
    }

    @Before
    public void setUpTest() {
        StrategyFactoryTinyURL strategyFactoryTinyURL = new StrategyFactoryTinyURL();
        tinyURLCreateComponent = new TinyURLCreateImpl(strategyFactoryTinyURL);
    }

    @Test
    public void setStrategySimpleNumber() {
        TinyURLCreateStrategy strategy = tinyURLCreateComponent.setStrategy(StrategyTinyURLChoice.SIMPLE_NUMBER);
        assertNotNull(strategy);
        assertEquals(strategy.getClass(), TinyCreateIDStrategy.class);
    }

    @Test
    public void setStrategyHashing() {
        TinyURLCreateStrategy strategy = tinyURLCreateComponent.setStrategy(StrategyTinyURLChoice.HASHING);
        assertNotNull(strategy);
        assertEquals(strategy.getClass(), TinyCreateHashStrategy.class);
    }


    @Test
    public void createTinyURLID() throws EmptyURLException {
        tinyURLCreateComponent.setStrategy(StrategyTinyURLChoice.SIMPLE_NUMBER);

        URL url = new URL();
        url.setUrlId(100);

        TinyURL tinyURL = tinyURLCreateComponent.createTinyURL(url);
        assertNotNull(tinyURL);
        assertEquals(tinyURL.getUrlId(), 100);
        assertEquals(tinyURL.getTinyURL(), "www.tinyurl.com/100");

    }

    @Test
    public void createTinyURLHash() throws EmptyURLException {
        tinyURLCreateComponent.setStrategy(StrategyTinyURLChoice.HASHING);

        URL url = new URL();
        url.setUrlId(100);

        TinyURL tinyURL = tinyURLCreateComponent.createTinyURL(url);
        assertNotNull(tinyURL);
        assertEquals(tinyURL.getUrlId(), 100);
        assertEquals(tinyURL.getTinyURL(), "www.tinyurl.com/bM");

    }

    @Test(expected = EmptyURLException.class)
    public void createTinyURLWithNullURL() throws EmptyURLException {

        URL url = null;

        TinyURL tinyURL = tinyURLCreateComponent.createTinyURL(url);
        assertNotNull(tinyURL);

    }

}
