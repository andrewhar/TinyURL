package com.tinyurl.api.service.responsecreater.urlcreate.normal;

import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.model.TinyURL;
import com.tinyurl.api.restcontrollers.dto.URLResponse;

public interface ValidResponseCreateComponent {

    URLResponse createResponse(OrgURL orgURL, TinyURL tinyURL);
}
