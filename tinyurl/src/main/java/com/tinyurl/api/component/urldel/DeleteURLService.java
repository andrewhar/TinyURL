package com.tinyurl.api.component.urldel;

import com.tinyurl.api.restcontrollers.dto.URLRequest;
import com.tinyurl.api.restcontrollers.dto.URLResponse;

public interface DeleteURLService {
    public URLResponse deleteURL(URLRequest request);
}
