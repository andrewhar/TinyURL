package com.tinyurl.api.component.responsecreater.urlcreate;

import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.model.TinyURL;
import com.tinyurl.api.restcontrollers.dto.URLResponse;
import org.springframework.stereotype.Component;

@Component
public class ResponseGeneralCreateImpl implements ResponseGeneralCreateComp {

    @Override
    public URLResponse makeResponse(OrgURL orgURL, TinyURL tinyURL) {
        URLResponse urlResponse = new URLResponse();
        urlResponse.setId(orgURL.getUrlId());
        urlResponse.setOrgURL(orgURL.getOrgURL());
        urlResponse.setTinyURL(tinyURL.getTinyURL());
        return urlResponse;
    }
}
