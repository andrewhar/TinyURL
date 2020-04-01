package com.tinyurl.api.service.urlcreator;

import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.model.URL;
import com.tinyurl.api.restcontrollers.dto.URLRequest;

public interface OrgURLCreateComponent {
    public OrgURL createOrgURL(URLRequest request, URL url);

    public OrgURL saveOrgURL(OrgURL orgURL);

}
