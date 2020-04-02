package com.tinyurl.api.component.urlfinder;

import com.tinyurl.api.model.OrgURL;

import java.util.Optional;

public interface OrgURLFinder {

   Optional<OrgURL> findOrgURLById(String longURL);
}
