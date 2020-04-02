package com.tinyurl.api.component.responsecreater.urlcreate;

import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.model.TinyURL;
import com.tinyurl.api.restcontrollers.dto.URLResponse;

public interface ResponseGeneralCreateComp {

    public URLResponse makeResponse(OrgURL url, TinyURL tinyURL);

}
