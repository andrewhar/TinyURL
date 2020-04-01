package com.tinyurl.api.service.urlregistration;


import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.model.TinyURL;
import com.tinyurl.api.model.URL;
import com.tinyurl.api.repository.OrgURLRepository;
import com.tinyurl.api.repository.TinyURLRepository;
import com.tinyurl.api.restcontrollers.dto.URLRequest;
import com.tinyurl.api.restcontrollers.dto.URLResponse;
import com.tinyurl.api.service.responsecreater.urlcreate.normal.ValidResponseCreateComponent;
import com.tinyurl.api.service.responsecreater.urlcreate.unnormal.ResponseExistedCreateComponent;
import com.tinyurl.api.service.urlcreator.OrgURLCreateComponent;
import com.tinyurl.api.service.urlcreator.TinyURLCreateComponent;
import com.tinyurl.api.service.urlcreator.URLCreateComponent;
import com.tinyurl.api.service.urlvalidator.URLRequestValidator;
import com.tinyurl.api.service.urlvalidator.ValidateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterURLImpl implements RegisterURLService {

    @Autowired
    URLCreateComponent urlCreateComponent;

    @Autowired
    OrgURLCreateComponent orgURLCreateComponent;

    @Autowired
    TinyURLCreateComponent tinyURLCreateComponent;

    @Autowired
    URLRequestValidator urlRequestValidator;

    @Autowired
    OrgURLRepository orgURLRepository;

    @Autowired
    TinyURLRepository tinyURLRepository;

    @Autowired
    ValidResponseCreateComponent validResponseCreateComponent;

    @Autowired
    ResponseExistedCreateComponent responseExistedCreateComponent;

    @Autowired
    public RegisterURLImpl(URLCreateComponent urlCreateComponent) {
        this.urlCreateComponent = urlCreateComponent;
    }

    @Override
    public URLResponse registerURL(URLRequest urlRequest) {
        System.out.println("[RegisterURLImpl] start registerURL");
        ValidateResult validateResult = urlRequestValidator.validate(urlRequest);
        switch (validateResult) {
            case EXISTED: {
                System.out.println("[RegisterURLImpl] already exist");
                Optional<OrgURL> orgURLOptional = orgURLRepository.findByOrgURL(urlRequest.getOrgURL());
                Optional<TinyURL> tinyURLOptional = tinyURLRepository.findById(orgURLOptional.get().getUrlId());
                URLResponse existedResponse = responseExistedCreateComponent.createResponse(orgURLOptional.get(), tinyURLOptional.get());
                return existedResponse;
            }
        }

        URL nURL = urlCreateComponent.createURL();
        URL dbURL = urlCreateComponent.saveURL(nURL);

        OrgURL orgURL = orgURLCreateComponent.createOrgURL(urlRequest, dbURL);
        TinyURL tinyURL = tinyURLCreateComponent.createTinyURL(dbURL, orgURL);

        orgURLCreateComponent.saveOrgURL(orgURL);
        tinyURLCreateComponent.saveTinyURL(tinyURL);

        URLResponse successResponse = validResponseCreateComponent.createResponse(orgURL, tinyURL);
        return successResponse;
    }
}
