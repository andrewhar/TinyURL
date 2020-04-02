package com.tinyurl.api.component.urlregistrationhelper;

import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.model.TinyURL;
import com.tinyurl.api.repository.OrgURLRepository;
import com.tinyurl.api.repository.TinyURLRepository;
import com.tinyurl.api.restcontrollers.dto.URLRequest;
import com.tinyurl.api.restcontrollers.dto.URLResponse;
import com.tinyurl.api.component.responsecreater.urlcreate.unnormal.ResponseExistedCreateComponent;
import com.tinyurl.api.component.urlvalidator.URLRequestValidator;
import com.tinyurl.api.component.urlvalidator.ValidateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RegURLValidationImpl implements RegURLValidationStep {

    @Autowired
    URLRequestValidator urlRequestValidator;

    @Autowired
    OrgURLRepository orgURLRepository;

    @Autowired
    TinyURLRepository tinyURLRepository;

    @Autowired
    ResponseExistedCreateComponent responseExistedCreateComponent;

    @Override
    public Optional<URLResponse> validate(URLRequest urlRequest) {
        ValidateResult validateResult = urlRequestValidator.validate(urlRequest);
        switch (validateResult) {
            case EXISTED: {
                System.out.println("[RegisterURLImpl] already exist");
                Optional<OrgURL> orgURLOptional = orgURLRepository.findByOrgURL(urlRequest.getOrgURL());
                Optional<TinyURL> tinyURLOptional = tinyURLRepository.findById(orgURLOptional.get().getUrlId());
                URLResponse existedResponse = responseExistedCreateComponent.createResponse(orgURLOptional.get(), tinyURLOptional.get());
                return Optional.of(existedResponse);
            }
        }
        return Optional.empty();
    }
}
