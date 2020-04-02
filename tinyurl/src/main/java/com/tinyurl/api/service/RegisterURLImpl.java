package com.tinyurl.api.service;


import com.tinyurl.api.component.urlregistrationhelper.RegURLMainStep;
import com.tinyurl.api.component.urlregistrationhelper.RegURLValidationStep;
import com.tinyurl.api.restcontrollers.dto.URLRequest;
import com.tinyurl.api.restcontrollers.dto.URLResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterURLImpl implements RegisterURLService {

    @Autowired
    RegURLValidationStep urlValidationStep;

    @Autowired
    RegURLMainStep urlMainStep;


    @Autowired
    public RegisterURLImpl() {

    }

    @Override
    public URLResponse registerURL(URLRequest urlRequest) {
        System.out.println("[RegisterURLImpl] start registerURL");
        //Validate if url request is valid / registered
        Optional<URLResponse> optionalURLResponse = urlValidationStep.validate(urlRequest);
        if (optionalURLResponse.isPresent()) return optionalURLResponse.get();

        //Create tiny url and the response
        URLResponse resp = urlMainStep.createRegURL(urlRequest);

        return resp;
    }
}
