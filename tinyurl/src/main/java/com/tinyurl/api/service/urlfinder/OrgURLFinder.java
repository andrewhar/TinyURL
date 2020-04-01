package com.tinyurl.api.service.urlfinder;

import com.tinyurl.api.model.OrgURL;

import java.util.Optional;

public interface OrgURLFinder {

   Optional<OrgURL> findOrgURLById(String longURL);
}
