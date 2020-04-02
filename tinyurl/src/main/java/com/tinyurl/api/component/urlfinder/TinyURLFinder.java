package com.tinyurl.api.component.urlfinder;

import com.tinyurl.api.model.TinyURL;

import java.util.Optional;

public interface TinyURLFinder {

    Optional<TinyURL> findTinyURL(int urlId);

}
