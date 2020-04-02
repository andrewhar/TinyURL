package com.tinyurl.api.component.responsecreater.urlcreate.unnormal;

import com.tinyurl.api.restcontrollers.dto.URLResponse;
import org.springframework.stereotype.Component;

@Component
public class RespExcepImpl implements  RespExcepComp{


    @Override
    public URLResponse createResponse(String errMsg) {
        URLResponse urlResponse = new URLResponse();
        urlResponse.setMsg(errMsg);
        return urlResponse;
    }
}
