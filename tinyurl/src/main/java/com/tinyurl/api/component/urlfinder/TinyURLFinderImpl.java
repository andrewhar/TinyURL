package com.tinyurl.api.component.urlfinder;

import com.tinyurl.api.model.TinyURL;
import com.tinyurl.api.repository.TinyURLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TinyURLFinderImpl implements TinyURLFinder{

    @Autowired
    TinyURLRepository tinyURLRepository;


    @Override
    public Optional<TinyURL> findTinyURL(int urlId) {

        Optional<TinyURL> optional= tinyURLRepository.findById(urlId);

        return optional;
    }
}
