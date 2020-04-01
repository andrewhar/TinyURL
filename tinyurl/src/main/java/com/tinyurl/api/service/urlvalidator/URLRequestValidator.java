package com.tinyurl.api.service.urlvalidator;

import com.tinyurl.api.restcontrollers.dto.URLRequest;

public interface URLRequestValidator {

    ValidateResult validate(URLRequest request);

}
