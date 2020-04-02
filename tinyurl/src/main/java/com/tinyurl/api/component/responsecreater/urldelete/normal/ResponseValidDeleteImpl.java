package com.tinyurl.api.component.responsecreater.urldelete.normal;

import com.tinyurl.api.restcontrollers.dto.URLResponse;
import org.springframework.stereotype.Component;

@Component
public class ResponseValidDeleteImpl implements ResponseValidDeleteComp {

    @Override
    public URLResponse createResp(String url) {
        URLResponse urlResponse = new URLResponse();
        urlResponse.setOrgURL(url);
        urlResponse.setMsg("Success Delete");
        return urlResponse;
    }
}
