package com.api.urlcreatecomponent;

import com.tinyurl.api.exception.EmptyRequestException;
import com.tinyurl.api.exception.EmptyURLException;
import com.tinyurl.api.model.OrgURL;
import com.tinyurl.api.repository.OrgURLRepository;
import com.tinyurl.api.component.urlcreator.OrgURLCreateImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.tinyurl.api.model.URL;
import com.tinyurl.api.restcontrollers.dto.URLRequest;

public class OrgURLCreateImplTest {
    URLRequest urlRequest;
    URL url;
    OrgURLCreateImpl orgURLCreate;

    @BeforeClass
    public static void beforeCreateImplTest() {
        System.out.println("Start testing orgUrl create impl");
    }

    @Before
    public void setUpTest() {
        urlRequest = new URLRequest();
        url = new URL();
        orgURLCreate = new OrgURLCreateImpl();
    }


    @Test
    public void testCreateOrgURL() throws EmptyRequestException, EmptyURLException {
        //set input
        urlRequest.setOrgURL("www.google.com");
        url.setUrlId(101);

        //execute
        OrgURL finalResult = orgURLCreate.createOrgURL(urlRequest, url);

        //compare
        assertNotNull(finalResult);
        assertEquals("www.google.com", finalResult.getOrgURL());
        assertEquals(101, finalResult.getUrlId());
    }

    @Test(expected = EmptyRequestException.class)
    public void testCreateOrgURLWithNullRequest() throws EmptyRequestException, EmptyURLException {
        urlRequest = null;
        OrgURL finalResult = orgURLCreate.createOrgURL(urlRequest, url);

        assertNotNull(finalResult);
    }

    @Test(expected = EmptyRequestException.class)
    public void testCreateOrgURLWithEmptyRequest() throws EmptyRequestException, EmptyURLException {
        OrgURL finalResult = orgURLCreate.createOrgURL(urlRequest, url);
        urlRequest.setOrgURL(null);
        assertNotNull(finalResult);
    }

    @Test(expected = EmptyURLException.class)
    public void testCreateOrgURLWithNullURL() throws EmptyRequestException, EmptyURLException {
        url = null;
        OrgURL finalResult = orgURLCreate.createOrgURL(urlRequest, url);

        assertNotNull(finalResult);
    }


    @Test
    public void testSaveOrgURL() {
        //mock dependency
        OrgURLRepository orgURLRepository = mock(OrgURLRepository.class);
        OrgURL orgURL = new OrgURL();
        orgURL.setUrlId(1);
        orgURL.setOrgURL("www.google.com");

        when(orgURLRepository.save(orgURL)).thenReturn(orgURL);
        orgURLCreate.setOrgURLRepository(orgURLRepository);

        OrgURL resURL = orgURLCreate.saveOrgURL(orgURL);

        assertNotNull(resURL);
        assertEquals(orgURL,resURL);
    }


}
