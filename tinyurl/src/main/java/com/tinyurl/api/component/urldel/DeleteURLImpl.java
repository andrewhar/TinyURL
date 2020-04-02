package com.tinyurl.api.component.urldel;

import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.repository.OrgURLRepository;
import com.tinyurl.api.repository.URLRepository;
import com.tinyurl.api.restcontrollers.dto.URLRequest;
import com.tinyurl.api.restcontrollers.dto.URLResponse;
import com.tinyurl.api.component.responsecreater.urldelete.normal.ResponseValidDeleteComp;
import com.tinyurl.api.component.responsecreater.urldelete.unnormal.NotExistedResponseComp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteURLImpl implements DeleteURLService {

    @Autowired
    URLRepository urlRepository;

    @Autowired
    OrgURLRepository orgURLRepository;

    @Autowired
    ResponseValidDeleteComp responseValidDeleteComp;

    @Autowired
    NotExistedResponseComp notExistedResponseComp;


    public URLResponse deleteURL(URLRequest request){
        String orgUrl = request.getOrgURL();
        Optional<OrgURL> orgURL = orgURLRepository.findByOrgURL(orgUrl);
        if(orgURL.isEmpty()) return notExistedResponseComp.createResponse();

        int urlId = orgURL.get().getUrlId();
        urlRepository.deleteById(urlId);

        return responseValidDeleteComp.createResp(request.getOrgURL());
    }
}
