package com.tinyurl.api.service.responsecreater.urlcreate.unnormal;

import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.model.TinyURL;
import com.tinyurl.api.restcontrollers.dto.URLResponse;

public interface ResponseExistedCreateComponent {

    URLResponse createResponse(OrgURL orgURL, TinyURL tinyURL);

}
