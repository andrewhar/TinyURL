package com.tinyurl.api.component.urlvalidator;

import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.repository.OrgURLRepository;
import com.tinyurl.api.restcontrollers.dto.URLRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class URLRequestValidatorImpl implements URLRequestValidator {

    @Autowired
    OrgURLRepository orgURLRepository;

    private boolean isURLValid(String queryLongURl){
        //
        return true;
    }

    private boolean isURLExist(String queryLongURl) {
        System.out.println("[isURLExist] queryLongURl=" + queryLongURl);
        Optional<OrgURL> orgURL = orgURLRepository.findByOrgURL(queryLongURl);

        boolean isExist = orgURL.isPresent();
        System.out.println("[isURLExist] isExist=" + isExist);
        return isExist;
    }

    @Override
    public ValidateResult validate(URLRequest request) {
        String queryLongURl = request.getOrgURL();
        if(!isURLValid((queryLongURl))) return ValidateResult.INVALID_URL;
        if(isURLExist(queryLongURl)) return ValidateResult.EXISTED;

        return ValidateResult.NOT_EXISTED;

    }
}
