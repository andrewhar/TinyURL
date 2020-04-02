package com.tinyurl.api.component.urlvalidator;

import com.tinyurl.api.restcontrollers.dto.URLRequest;

public interface URLRequestValidator {

    ValidateResult validate(URLRequest request);

}
