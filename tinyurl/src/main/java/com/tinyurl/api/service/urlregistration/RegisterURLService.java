package com.tinyurl.api.service.urlregistration;

import com.tinyurl.api.repository.OrgURLRepository;
import com.tinyurl.api.repository.TinyURLRepository;
import com.tinyurl.api.repository.URLRepository;
import com.tinyurl.api.restcontrollers.dto.URLRequest;
import com.tinyurl.api.restcontrollers.dto.URLResponse;


public interface RegisterURLService {

    public URLResponse registerURL(URLRequest urlRequest);

}
