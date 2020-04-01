package com.tinyurl.api.service.responsecreater.urlcreate.normal;

import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.model.TinyURL;
import com.tinyurl.api.restcontrollers.dto.URLResponse;
import com.tinyurl.api.service.responsecreater.urlcreate.ResponseGeneralCreateComp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidResponseCreateImpl implements ValidResponseCreateComponent {

    @Autowired
    ResponseGeneralCreateComp responseGeneralCreateComp;

    @Override
    public URLResponse createResponse(OrgURL orgURL, TinyURL tinyURL) {
        URLResponse urlResponse = responseGeneralCreateComp.makeResponse(orgURL, tinyURL);
        return urlResponse;
    }

}
