package com.api.urlcreatecomponent;

import com.tinyurl.api.repository.URLRepository;
import com.tinyurl.api.component.urlcreator.URLCreateComponent;
import com.tinyurl.api.component.urlcreator.URLCreateImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.tinyurl.api.model.URL;

import java.time.LocalDateTime;
import java.time.Month;

public class URLCreateImplTest {
    URL url;
    URLCreateComponent urlCreateComponent;

    @BeforeClass
    public static void beforeCreateImplTest() {
        System.out.println("Start testing url create impl");
    }

    @Before
    public void setUpTest() {
        url = new URL();
        urlCreateComponent = new URLCreateImpl();
    }

    @Test
    public void testCreateURL(){
        URL res = urlCreateComponent.createURL();
        assertNotNull(res);

    }

    @Test
    public void testSaveURL() {
        URLRepository urlRepository = mock(URLRepository.class);
        //mock input
        LocalDateTime aDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
        url.setCreatedDate(aDateTime);
        //mock the dependency
        URLCreateImpl urlCreateImpl = new URLCreateImpl();
        urlCreateImpl.setUrlRepository(urlRepository);
        when(urlRepository.save(url)).thenReturn(url);
        //execute
        URL finalResult = urlCreateImpl.saveURL(url);
        //compare
        assertNotNull(finalResult);
        assertEquals(url, finalResult);
    }

}
