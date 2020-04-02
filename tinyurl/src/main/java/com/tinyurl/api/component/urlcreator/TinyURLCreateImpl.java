package com.tinyurl.api.component.urlcreator;

import com.tinyurl.api.exception.EmptyURLException;
import com.tinyurl.api.model.TinyURL;
import com.tinyurl.api.model.URL;
import com.tinyurl.api.repository.TinyURLRepository;
import com.tinyurl.api.component.strategy.tinyURLcreation.StrategyFactoryTinyURL;
import com.tinyurl.api.component.strategy.tinyURLcreation.StrategyTinyURLChoice;
import com.tinyurl.api.component.strategy.tinyURLcreation.TinyURLCreateStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TinyURLCreateImpl implements TinyURLCreateComponent {


    @Autowired
    private TinyURLRepository tinyURLRepository;

    private StrategyTinyURLChoice strategyChoice;

    private TinyURLCreateStrategy strategy;

    private StrategyFactoryTinyURL strategyFactory;


    @Autowired
    public TinyURLCreateImpl(StrategyFactoryTinyURL strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    @Override
    public TinyURLCreateStrategy setStrategy(StrategyTinyURLChoice choice) {
        strategyChoice = choice;
        strategy = strategyFactory.factoryMethod(choice);
        return strategy;
    }

    @Override
    public TinyURL createTinyURL(URL url) throws EmptyURLException {
        TinyURL tinyURL = new TinyURL();
        if(url==null) throw new EmptyURLException();
        String input = String.valueOf(url.getUrlId());

        String tinyURLOutput = strategy.createTiny(input);

        tinyURL.setUrlId(url.getUrlId());
        tinyURL.setTinyURL(tinyURLOutput);

        return tinyURL;
    }

    @Override
    public TinyURL saveTinyURL(TinyURL tinyURL) {
        return tinyURLRepository.save(tinyURL);
    }


}
