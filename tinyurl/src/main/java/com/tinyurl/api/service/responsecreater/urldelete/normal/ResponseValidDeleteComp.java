package com.tinyurl.api.service.responsecreater.urldelete.normal;

import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.restcontrollers.dto.URLResponse;

public interface ResponseValidDeleteComp {

    URLResponse createResp(String url);
}
