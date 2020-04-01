package com.tinyurl.api.service.responsecreater.urldelete.unnormal;

import com.tinyurl.api.restcontrollers.dto.URLResponse;
import org.springframework.stereotype.Component;

@Component
public class NotExistedResponseImpl implements NotExistedResponseComp {

    @Override
    public URLResponse createResponse() {
        URLResponse urlResponse = new URLResponse();
        urlResponse.setErrorMsg("Not Existed");
        return urlResponse;

    }
}
