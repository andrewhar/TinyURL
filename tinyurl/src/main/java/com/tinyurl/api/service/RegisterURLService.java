package com.tinyurl.api.service;

import com.tinyurl.api.restcontrollers.dto.URLRequest;
import com.tinyurl.api.restcontrollers.dto.URLResponse;


public interface RegisterURLService {

    public URLResponse registerURL(URLRequest urlRequest);

}
