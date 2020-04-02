package com.tinyurl.api.component.urlregistrationhelper;

import com.tinyurl.api.exception.EmptyRequestException;
import com.tinyurl.api.exception.EmptyURLException;
import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.model.TinyURL;
import com.tinyurl.api.model.URL;
import com.tinyurl.api.restcontrollers.dto.URLRequest;
import com.tinyurl.api.restcontrollers.dto.URLResponse;
import com.tinyurl.api.component.responsecreater.urlcreate.normal.ValidResponseCreateComponent;
import com.tinyurl.api.component.responsecreater.urlcreate.unnormal.RespExcepComp;
import com.tinyurl.api.component.strategy.tinyURLcreation.StrategyTinyURLChoice;
import com.tinyurl.api.component.urlcreator.OrgURLCreateComponent;
import com.tinyurl.api.component.urlcreator.TinyURLCreateComponent;
import com.tinyurl.api.component.urlcreator.URLCreateComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegURLMainStepImpl implements RegURLMainStep {
    @Autowired
    URLCreateComponent urlCreateComponent;

    @Autowired
    OrgURLCreateComponent orgURLCreateComponent;

    @Autowired
    TinyURLCreateComponent tinyURLCreateComponent;


    @Autowired
    ValidResponseCreateComponent validResponseCreateComponent;


    @Autowired
    RespExcepComp respExcepComp;

    private URL createNewURL() {
        URL nURL = urlCreateComponent.createURL();
        return nURL;
    }

    private URL createDbURL(URL nURL) {
        URL dbURL = urlCreateComponent.saveURL(nURL);
        return dbURL;
    }

    private OrgURL createOrgURL(URLRequest urlRequest, URL dbURL) throws EmptyRequestException, EmptyURLException {
        OrgURL orgURL = orgURLCreateComponent.createOrgURL(urlRequest, dbURL);
        return orgURL;
    }

    private TinyURL createTinyURL(URL dbURL) throws EmptyURLException {
        tinyURLCreateComponent.setStrategy(StrategyTinyURLChoice.SIMPLE_NUMBER);
        TinyURL tinyURL = tinyURLCreateComponent.createTinyURL(dbURL);
        return tinyURL;
    }

    @Override
    public URLResponse createRegURL(URLRequest urlRequest) {
        URL nURL = createNewURL();
        URL dbURL = createDbURL(nURL);

        URLResponse resp = null;
        try {
            OrgURL orgURL = createOrgURL(urlRequest, dbURL);
            TinyURL tinyURL = createTinyURL(dbURL);
            orgURLCreateComponent.saveOrgURL(orgURL);
            tinyURLCreateComponent.saveTinyURL(tinyURL);
            resp = validResponseCreateComponent.createResponse(orgURL, tinyURL);
        } catch (EmptyRequestException e) {
            resp = respExcepComp.createResponse("Empty Request");
        } catch (EmptyURLException e) {
            resp = respExcepComp.createResponse("Empty URL");
        }

        return resp;
    }
}
