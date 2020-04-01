package com.tinyurl.api.service.urlcreator;

import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.model.TinyURL;
import com.tinyurl.api.model.URL;
import com.tinyurl.api.repository.TinyURLRepository;
import com.tinyurl.api.service.strategy.tinyURLcreation.TinyURLCreateStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TinyURLCreateImpl implements TinyURLCreateComponent {

    @Autowired
    TinyURLCreateStrategy strategy;

    @Autowired
    TinyURLRepository tinyURLRepository;

    @Override
    public TinyURL createTinyURL(URL url, OrgURL orgURL) {
        TinyURL tinyURL = new TinyURL();
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
