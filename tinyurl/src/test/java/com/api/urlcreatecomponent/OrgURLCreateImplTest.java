package com.api.urlcreatecomponent;

import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.repository.OrgURLRepository;
import com.tinyurl.api.repository.URLRepository;
import com.tinyurl.api.service.urlcreator.OrgURLCreateImpl;
import com.tinyurl.api.service.urlcreator.URLCreateImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.tinyurl.api.model.URL;
import com.tinyurl.api.restcontrollers.dto.URLRequest;

import java.io.Reader;
import java.time.LocalDateTime;
import java.time.Month;

public class OrgURLCreateImplTest {
    URLRequest urlRequest;
    URL url;

    @Before
    public void setUpOrgURL() {
        URLRequest urlRequest = new URLRequest();
        URL url = new URL();
    }

    @Test
    public void testCreateOrgURL() {

        //set input
        urlRequest.setOrgURL("www.google.com");
        url.setUrlId(101);

        //execute
        OrgURLCreateImpl orgURLCreate = new OrgURLCreateImpl();
        OrgURL finalResult = orgURLCreate.createOrgURL(urlRequest, url);

        //compare
        assertNotNull(finalResult);
        assertEquals("www.google.com", finalResult.getOrgURL());
        assertEquals(101, finalResult.getUrlId());
    }

    @Test
    public void testSaveOrgURL() {
        //mock dependency
        OrgURLRepository orgURLRepository = mock(OrgURLRepository.class);
    }


}
