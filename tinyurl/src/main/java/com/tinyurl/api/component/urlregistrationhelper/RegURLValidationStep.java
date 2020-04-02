package com.tinyurl.api.component.urlregistrationhelper;

import com.tinyurl.api.restcontrollers.dto.URLRequest;
import com.tinyurl.api.restcontrollers.dto.URLResponse;

import java.util.Optional;

public interface RegURLValidationStep {

    Optional<URLResponse> validate(URLRequest urlRequest);
}
