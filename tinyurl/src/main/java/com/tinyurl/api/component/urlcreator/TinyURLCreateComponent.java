package com.tinyurl.api.component.urlcreator;

import com.tinyurl.api.exception.EmptyURLException;
import com.tinyurl.api.model.TinyURL;
import com.tinyurl.api.model.URL;
import com.tinyurl.api.component.strategy.tinyURLcreation.StrategyTinyURLChoice;
import com.tinyurl.api.component.strategy.tinyURLcreation.TinyURLCreateStrategy;

public interface TinyURLCreateComponent {

     TinyURL createTinyURL(URL url) throws EmptyURLException;

     public TinyURL saveTinyURL(TinyURL tinyURL);

     public TinyURLCreateStrategy setStrategy(StrategyTinyURLChoice choice);

}
