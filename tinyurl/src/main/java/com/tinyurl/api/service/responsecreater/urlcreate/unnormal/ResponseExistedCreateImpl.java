package com.tinyurl.api.service.responsecreater.urlcreate.unnormal;

import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.model.TinyURL;
import com.tinyurl.api.restcontrollers.dto.URLResponse;
import com.tinyurl.api.service.responsecreater.urlcreate.ResponseGeneralCreateComp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponseExistedCreateImpl implements ResponseExistedCreateComponent {


    @Autowired
    ResponseGeneralCreateComp responseGeneralCreateComp;

    @Override
    public URLResponse createResponse(OrgURL orgURL, TinyURL tinyURL) {
        URLResponse urlResponse = responseGeneralCreateComp.makeResponse(orgURL, tinyURL);
        urlResponse.setErrorMsg("Already Registered");
        return urlResponse;

    }
}
