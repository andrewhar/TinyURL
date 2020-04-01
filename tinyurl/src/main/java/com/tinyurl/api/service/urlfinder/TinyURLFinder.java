package com.tinyurl.api.service.urlfinder;

import com.tinyurl.api.model.TinyURL;

import java.util.Optional;

public interface TinyURLFinder {

    Optional<TinyURL> findTinyURL(int urlId);

}
