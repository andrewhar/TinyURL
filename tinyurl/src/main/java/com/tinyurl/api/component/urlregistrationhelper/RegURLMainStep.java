package com.tinyurl.api.component.urlregistrationhelper;

import com.tinyurl.api.restcontrollers.dto.URLRequest;
import com.tinyurl.api.restcontrollers.dto.URLResponse;

public interface RegURLMainStep {
    URLResponse createRegURL(URLRequest urlRequest);
}
