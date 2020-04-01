package com.tinyurl.api.service.urlcreator;

import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.model.URL;
import com.tinyurl.api.repository.OrgURLRepository;
import com.tinyurl.api.repository.URLRepository;
import com.tinyurl.api.restcontrollers.dto.URLRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrgURLCreateImpl implements OrgURLCreateComponent {

    @Autowired
    private OrgURLRepository orgURLRepository;

    public OrgURLCreateImpl(){

    }

    public OrgURL createOrgURL(URLRequest request, URL url) {
        System.out.println("[OrgURLCreateImpl] createOrgURL");
        OrgURL orgUrl = new OrgURL();
        orgUrl.setUrlId(url.getUrlId());
        orgUrl.setOrgURL(request.getOrgURL());
        System.out.println("[OrgURLCreateImpl] createOrgURL:"+orgUrl);
        return orgUrl;
    }

    @Override
    public OrgURL saveOrgURL(OrgURL orgURL) {
        System.out.println("[OrgURLCreateImpl] saveOrgURL: orgURL="+orgURL);
        OrgURL res = orgURLRepository.save(orgURL);
        return res;
    }

}
