package com.api.urlcreatecomponent;

import com.tinyurl.api.repository.URLRepository;
import com.tinyurl.api.service.urlcreator.URLCreateImpl;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.tinyurl.api.model.URL;
import com.tinyurl.api.restcontrollers.dto.URLRequest;

import java.time.LocalDateTime;
import java.time.Month;

public class URLCreateImplTest {
    @Test
    public void testSaveURL() {
        URLRepository urlRepository = mock(URLRepository.class);
        //mock input
        URL testURL = new URL();
        LocalDateTime aDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
        testURL.setCreatedDate(aDateTime);
        //mock the dependency
        URLCreateImpl urlCreateImpl = new URLCreateImpl(urlRepository);
        when(urlRepository.save(testURL)).thenReturn(testURL);
        //execute
        URL finalResult = urlCreateImpl.saveURL(testURL);
        //compare
        assertNotNull(finalResult);
        assertEquals(testURL, finalResult);
    }

}
