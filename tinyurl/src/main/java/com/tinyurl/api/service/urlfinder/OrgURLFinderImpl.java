package com.tinyurl.api.service.urlfinder;

import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.repository.OrgURLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrgURLFinderImpl implements  OrgURLFinder {

    @Autowired
    OrgURLRepository orgURLRepository;

    @Override
    public Optional<OrgURL> findOrgURLById(String longURL) {
        Optional<OrgURL> optional=orgURLRepository.findByOrgURL(longURL);
        return optional;
    }
}
