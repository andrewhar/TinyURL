package com.tinyurl.api.component.urlcreator;

import com.tinyurl.api.exception.EmptyRequestException;
import com.tinyurl.api.exception.EmptyURLException;
import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.model.URL;
import com.tinyurl.api.restcontrollers.dto.URLRequest;

public interface OrgURLCreateComponent {
    public OrgURL createOrgURL(URLRequest request, URL url) throws EmptyRequestException, EmptyURLException;

    public OrgURL saveOrgURL(OrgURL orgURL);

}
